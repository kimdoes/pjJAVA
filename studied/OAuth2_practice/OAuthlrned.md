# OAuth2 강의 (생활코딩)
OAuth에서는 3명의 참여자가 등장함

1. 나 (mine)
2. 사용자 (User)
3. 나의 서비스를 연동하려하는 그들 (Their) (예시 : 구글, 페이스북, 트위터 등...)

ex) 사용자(User)가 우리(mine) 서비스에 접속하여 이용함. 나의 서비스가 사용자를 대신하여 구글서비스, 페이스북 등의 서비스(Thier)에 접속하여 기록을 남기는 것.

우리가 사용자로부터 사용자의 그들의 서비스에 접근할 수 있도록 허가를 받아야함
가장 간단한 방법 : ID, PW를 사용자로부터 전달받아 기억하고 그들의 서비스에 사용함 -> 위험함, 강력함, 보안우려, 부담 증가

--> 이를 개선하기 위한 것이 oAuth. 안정성 증가 가능

## OAuth 매커니즘
User의 요청에 의해 그들의 서비스가 ID, PW 대신 accessToken 발급 (일종의 비밀번호)
accessToken -> 그들의 ID, PW가 아님 / 그들의 서비스에서 나의 서비스가 필요하는 것만 이용할 수 있도록 하는 비밀번호

OAuth를 통해 나의 서비스가 accessToken을 발급함 -> 토큰을 통해 그들의 서비스에 접근하여 데이터를 명령이행
OAuth의 특징을 이용하면 회원식별을 구현할 수 있음 -> 회원가입으로 회원정보저장할 필요 없음

## OAuth 용어
Thier -> Resource Server (데이터저장) / Authorization Server (인증과 관련된 처리를 전담함)
User -> Resource Owner
mine -> Client

### OAuth 등록과 승인인
Client에 서버를 이용하기 위해서 사전승인(Register)이 필요함 -> 서비스마다 다 다름
공통적으로는

Client ID       /        Client Secret             /             Authorized redirect URLs 를 발급받음
만들고 있는 앱의 식별자 / 식별자에 대한 비밀번호(노출되면 안됨) / 서버가 권한을 부여하는 과정에서 Authorized code를 전달하는데, 전달받을 주소

로 이루어짐

예시 / Display Name -> 자신의 주소
facebookLogin -> 후 사이트 주소가 필요함

### 승인
서버와 클라이언트는 모두 ID, Secret, redirect URL 을 앎. Client는 URL 페이지를 구현하고 준비해놔야함 -> 개발 중이라면 localhost 사용가능

리소스서버가 제공하는 기능은 A,B,C,D이 있을 때, B,C에 대한 기능만 클라이언트가 필요하다면..

리소스오너가 클라이언트에 접속할 때 리소스 서버를 사용해야할 상황일 경우, 리소스 오너에게 소셜로그인 화면이나 리소스 서버의 인증이 필요하다는 화면을 보임. (동의구함) -> 버튼에는 resource.server/?client_id=1&scope=B,C&redirect_url=https... 만 있으면 됨 / scope는 사용할 기능

오너가 서버로 접속하게됨 (버튼에 명시된 주소)
로그인이 되어 있지 않은 경우 리소스서버가 로그인 화면을 제공함

1. 리소스 오너의 승인
로그인이 성공할 경우 리소스서버가 클라이언트 ID 값과 같은 클라이언트 ID가 있는지 확인, 요청 리다이렉트 url과 가지고 있는 리다이렉트 url 확인 -> 같은 경우 scope에 있는 기능을 부여할 지에 대한 여부확인을 오너에게 전송 (허용할 것입니까?) -> 허용할 경우 리소스서버가 허용했다는 정보를 받아 오너의 유저id와 scope의 정보를 받음



2. 리소스 서버의 승인
리소스서버가 authorization code를 만들어 리소스 오너에게 전송함
location : https://client/callback?code=3  (서버가 오너의 웹브라우저에게 이동명령을 보냄) -> 주소로 이동 -> client는 authorization code를 획득함 -> 클라이언트는 리소스서버에 직접 접속
https://resource.server/token?grant_type=authorization_code&code=3&redirect_rul=https://client/callback&client_id=1&client_secret=2 전송

리소스서버는 authorization code, client id와 client secret, redirect_url 일치여부 확인, 일치할 경우 토큰 발급


accessToken 발급
클라이언트와 리소스서버는 authorization 코드가 필요없기에 지움

리소스서버는 acessToken을 발급하고 클라이언트에게 응답함 -> 클라이언트는 내부에 저장함 -> accessToken은 user_id 에게서 scope 의 권한이 부여되었다는 것을 의미함

## API 호출
리소스서버를 조작해야함
API (Application Programming Interface)

클라이언트가 리소스서버를 호출할 때, 일종의 조작장치 역할을 함
client -> API -> ResourceServer (예시 : Google Calender API)
google.apis.com/calendar/v3/users/calendar 등... -> accessToken이 있어야함

google api access token auth
