## 전자정부 표준프레임워크 커스터마이징 

***
### 커스터 마이징 후 파스타 클라우드 활용예정(공통)
1. 스프링프로젝트 Leejy_egov 변경 -> Leejy-egov.
2. 이클립스에서 Leejy-egov 프로젝트를 파스타에 배포.(Mysql용)
3. Leejy-egov 프로젝트용 클라우드 DB생성: 서비스명은 egov-mysql-db.
4. 파스타 클라우드에서 egov-mysql-db의 원격접속이름과 암호를 확인.
5. 이미 생성된 phpmyadmin 애플리케이션명: Leejy-myadmin 실행.
6. http://Leejy-myadmin.paas-ta.org 접속후 전자정부 프로젝트용 더미데이터 인서트.
7. http://Leejy-egov.paas-ta.org 사이트에서 파스타 배포결과 확인. 

### 20200915(화)
- 앞으로 수업진도 예정(아래)
- v13.0.0은: 노드MCU(+LED램프)와아두이노IDE개발 와이파이(외부램프깜박임)
- v14.0.0은: 라즈베리와 PC USB to UART 시리얼 유선통신(실시간 채팅)
- v15.0.0은:노드MCU(+블루투스)과스마트폰앱 블루투스통신(내부램프깜박)
- v16.0.0은:스마트폰앱과 스프링프로젝트(+DB)와 사용자조회+삭제(와이파이)
- 애플리케이션 테스트 수행-완료보고서용 프로젝트 아키텍쳐 구글 시프레드시트 작업
- 애플리케이션 테스트 수행-인수테스트용 프로젝트 매뉴얼 구글 프레젠테이션 작업
- 전자정부 프로젝트 리뉴얼 -사용자단 게시판 처리 추가 후 파스타 배포(시간날때)

- 라즈베리 보드 리뷰.
- 노드MCU보드 리뷰.
- 부트로더: 노드MCU(아두이노)에 전원ON 후 최초로 실행되는 부분
- 전원ON 후 최초로 실행되는 영역이 부트로더 입니다.
- 부트로더에서 하는일(웹서버실행-LED 온/오프 시키기)
- 개발환경 아두이노IDE, 개발언어는 스케치(간단한C언어)
- 선색: 갈색(+3.3V), 검은색(-선), 흰색(RX핀GP1), 회색(TX핀GP3)
- 핀연결: TX(노드MCU1핀)-RX(브루투스),RX(노드MCU3핀)-TX(블루투스)
- 브레드보드(빵판)는 사용하지 않습니다.
- GPIO: General Purpose Input Output 일반목적의 입출력핀.
- 위 GPIO핀 번호를 가지고, 개발자가 전압을 High, Low 값을 줘서
- 아두이노IDE개발툴(이클립스와같은역할) 
- 블루투스는 이칩에 없고, 외부에 연결해서 사용합니다.
- 핀4개: VCC(+), GND(-), RX(리스브), TX(송신) 총 4핀으로 구성.
- 블루투스 HC-06 칩이름 4핀(2개 전원+, - / 2개 in,out 핀)
- 미니usb포트로 5V가 입력 -> 레큘레이터 LM1117거치면 -> 3.3V
- USB to UART 칩1 + ESP8266 MCU칩1 + 레큘레이터(5V->3.3V 전압변)
- UART(노드MCU, 라즈베리사용) to USB(PC에서 com포트로 사용)
- USB to UART, UART to USB
- UART(Universal Async Receiver/Transmitter):
- 범용 비동기 수신/송신 기술.
- 동기-순서(1등으로 전송하면, 1등 수신가능
- 비동기-비순서(1등으로 전송하다고, 1등 수신은 대중없음)
- MCU(마이크로 컨트롤러 유닛): 마이컴: 1게의 칩(반도체회로)에
- 모든 기능이 들어있는 반도체 = 올인원 All In ONE 칩
- 교재(아두이노)- 우리는 노드MCU보드(아두이노아류)
- 안드로이드 스튜디오 2020버전에서 Git 연동방법: https://mainia.tistory.com/5996
- 안드로이드 스튜디오 IDE버전 4.0.1 (개발API버전 30) : 모두 최신버전
- 어제는 도스에서 git 사용했으나, 오늘부터는 VCS 메뉴 사용.
- Intent 는 실행할 인스턴스를 담는 봉투역할.
- 실행은 startActivity(인텐트명);
- 오버로드 Intent(출력할 위치this, 출력할 콘텐츠activity);
- 오버로드 Intent(실행할 액션action_view, 파싱정보http:,tel:);
- 안드로이드 액티비티 화면이동의 특징(아래-웹페이지이동과는 틀림)
- 액티비티(화면)에서 다른 액티비티(화면) 호출한다고해서,
- 기존 액티비티(화면)이 종료되는게 아닙니다.
- 기존 액티비티(화면) 위쪽에 호출된 액티비티(화면)이 올라타는 구조
- 그래서 서브액티비티에서 finish()메서드를 실행하면, 
- 현재 액티비티가 종료되고, 밑에 있던 메인액티비티가 나타납니다.
- 액티비트를 추가하면, AndroidManifest(명세파일)에 자동으로 등록됨
- 스프링에서 빈(실행가능한 클래스)으로 등록되는 방식과 같습니다.
- 액티비티(화면)이 2개 만들어 졌습니다.(실행액티비티 MainActivity)
- layout_weight: 레이아웃을 잡는데, 무게(weight)를 1:1:1
- Constraint 레이아웃(특징:화살표) : 안드로이 스튜디오 초기값
- *Linear 레이아웃(특징:라인Line,방향:Orentaion오리엔테이션:Vertical,Horizantal)
- 작업한 안드로이드 프로젝트 깃 https://github.com/miniplugin/AndroidProjects
- DoItAndroid 프로젝트(슬라이드보면서 기초작업 하고있는 중...)
- 앞으로 하실 예정: AndroidSpringDb(RestAPI사용앱)  + Spring(앱용RestAPI서버추가)
- 앞으로 하실 예정: SmartBlue(스마트폰앱과 아두이노[+블루투스모듈장치] 통신앱)
#### 작업예정
- 라즈베리는 3대가 있기 때문에, 7명 1조.
- 7명중 1명 작업하시고, 나머지분들은 떨어져서 참관하시는 것으로
- 개인 스마트폰으로 찍어서 PPT로 정리해서 제출하시는 것으로 대체.
- 결과물 ppt파일은 각각 제출하시는 것으로.
- wiringPi 라이브러리 : 
- C언어로 라즈베리 파이의 GPIO(핀)번호를 제어하는 외부도구.
- 파이썬으로 라즈베리 파이의 핀번호를 제어하는 것이 기본.
- C언어로 GPIO(핀)번호를 제어하려면, wiringPi 라이브러리가 #include 필요.
- 라즈베리 터미널 창에서 실행해서 wiringPi 라이브러리를 설치.
- 액티비티간 데이터 전달: 참고자료 https://coding-factory.tistory.com/203
- ADB: 안드로이드 디버그 브릿지 스마트폰과 안드로이드스튜디오 디버그 연결관리
- 슬라이드 42번째장 부터 계속 이어서 작업.OK.
- 애플리케이션 테스트 수행-완료보고서용 프로젝트 아키텍쳐 구글 시프레드시트 작업
- 애플리케이션 테스트 수행-인수테스트용 프로젝트 매뉴얼 구글 프레젠테이션 작업
- 전자정부 프로젝트 리뉴얼 -사용자단 게시판 처리 추가 후 파스타 배포(시간날때)

### 20200914(월)
- 도스창에서 초기 깃 업로드 방법(아래)

```
git init
git add .
git commit -m "first commit"
git branch -M master
git remote add origin 여러분 깃 생성 주소.git
git push -u origin master
```
- 안드로이드 프로젝트는 워크스페이스에 저장.
- 워크스페이스 폴더는 D:/AndroidStudioProjects 폴더에 프로젝트 이름의 폴더로 만듬.
- 안드로이드 재시작하는 방법 File메뉴 > Invalidate Caches / Restart 메뉴를 클릭함.
- 백 화면으로 들어가는 구조 입니다. 그래서, 뒤로가기 가능합니다.
- startActivity로 다른 화면(Activity)를 호출한다고 해서, 현재 앱이 종료되는 것이 아님.
- startActivity는 다른 화면(Activity)를 호출하는 메서드 입니다. 
- 액션view는 안드로이드가 Uri.parse(값)을 분석해서, 해당되는 앱을 호출합니다.
- 파싱값이 url면 브라우저앱를 호출하고, 파싱값이 전화번호면 전화걸기앱을 호출합니다.
- Intent(봉투) new Intent(액션view, 리소스) -> startActivity(화면호출_띄웁니다.)
- layout_weight:각 1(1:1:1) 3등분, 가로는 꽉차게: layout_width:match_parent(부모창에맞추기)
- 레이아웃 변경Convert: Constraint -> Linear 레이아웃으로 변경. layout_weight사용
- 리니어레이아웃: Orientation(리니어:방향)가로(Horizontal),세로(Vertical)
- ***네이티브 앱(안드로이드), 반응형 웹(html5,css,js)
- Toast.makeText(출력위치,출력내용,출력시간).show(); 함수를 2개를 연달아 실행하는 방식을 사용합니다.
- 토스트(네모난 빵 토스트기계에서 튀어 나오는 모양과 비슷합니다.)
- 주의 Toast 입력 힌트 사용시, 내용중 회식 글자(context:, text:)는 타이핑 하지 마세요.
- 안드로이드 스튜디오는 자동저장됩니다.(이클립스는 수동저장 차이점)
- 여기서 말하는 View (레이아웃, 버튼, 텍스트뷰, 이미지뷰 등등)
- 사용방식은 이클립스(메인븐)과 비슷합니다.
- 자바 메서드 추가하는 방법: 화면에서 onClick 이벤트에 대한 메서드생성은
- 스프링에서 인터페이스와 임플리먼트에서 Add Implements method 방식과 똑같습니다.

```
<input type="text" />
<input type="button" />
```
- 화면출력 로직: @string(변수) -> xml에서 변수호출 -> java 화면렌더링:setContentView()
- 화면에 그래픽을 표시하는 과정을 렌더링이라고 합니다.
- drawable(드로잉이미지)를 xml로 만든다는 의미:아래
- 버튼이미지-버튼눌려졌을때 상태1-버튼눌리지 않았을때 상태2
- 위 상태2가지를 1개의 이미지로 처리 못합니다. -> xml처리한다.
- 2.3.3버전에는 androidx라는 라이브러리가 없었습니다. -> 3.x 버전부터 생겼습니다.
- 화면이 생성될때 savedInstanceState: 객체(오브젝트,인스턴스)상태를 저장.
- 위 의미는 회원가입 중인 화면이라고 가정하면,
- 이름, 이메일 입력 후 만약 밑에 개인정보보호 상세보기 클릭을 화면이동 가능 합니다.
- 개인정보보호 화면으로 이동해서 내용확인 후 이전화면으로 이동했을때...
- savedInstanceState 항목이 없으면, 기존에 입력했던 이름, 이메일 내용이 없어집니다.
- 그래서, super.onCreate(savedInstanceState); 항목이 필수로 필요합니다.
- 구조 R.layout.화면명경로: R(root,Resource약자).layout(폴더명).화면xml파일
- setContentView(R.layout.activity_main);//우리가만든 화면을 스마트폰에 뿌려주는역할
- wiper(자동차창문와이퍼) date -> 스마트폰 공장초기화 하고 같은 기능입니다.
- 실행전 AVD 매니저로 애뮬레이터 먼저 실행해 봅니다.
- @string을 사용하면 가장큰 장점은 앱에서 다국어 지원이 쉽게 됩니다.
- 현재 콤포넌트 트리에 보이는 노란색은 @string 사용을 추천하고, 직접입력 자제요청.
- 콤포넌트 트리에 노란색 느낌표는 상관없지만, 빨간색 경고창은 해결해줘야 합니다.
- 화면왼쪽아래 콤포넌트 트리에 보이는 TextView 클래스의 선을 콘스트레인트선이라고 함
- Constraint선: 제약선 ( 워크벤치ERD에서 테이블간의 관계선: 제약조건 Constraint)
- 뷰개체간의 관계를 나타내는 선입니다.
- 안녕하세요\n안드로이드!
- 문자크기단위: 12px(픽셀-웹전용) -> 44sp(앱전용:scale pixel 스케일 픽셀)
- 문자가아닌뷰/위젯단위: dp(앱전용: density pixel 덴서티;밀도 픽셀)
- 내핸드폰 가로 500px 화면에서 50px인 이미지있으면 -> dp 단위에서는(아래)
- 다른사람스마트폰에서 가로 1000px 화면에서는 자동으로 100px 이미지로 자동크기조정.
- 앱 sp/dp 특징은 화면이 확대 되어도 반응형으로 자동크기유지. px(웹)은 고정크기.
- 디자인(이미지미리보기가능) | 청사진(와이어프레임-레이아웃만보임)
- 다른개발자가 만든 App프로그램 크기(범위)를 알고 싶으면, AdroidManifest 파일을 확인
- 인텔리J IDE에디터(안드로이드) = 이클립스 IDE에디터(스프링)
- manifests: 안드로이드App설정 파일로 중요함. 이전에 파스타 설정파일(manifest.xml)
- 위 매니페스트파일에 화면정보가 존재하고, 액티비티를 추가할때마다,
- 위 매니페스트파이에 Activity(화면)가 추가됩니다.
- 그래서, AdroidManifest.xml 파일은 액티비티 명세(목차)가 저장되는 공간입니다.

- AVD(안드로이드 버추얼 디바이스:스마트폰가상장치)=애뮬레이터
- 프로그램 누구나 만들수 있습니다. 문서는 아무나 만들 수 없습니다.
- 예외처리(Exception)하는 목적: 에러가 발생하더라도 프로그램 계속사용가능.
- 403 상태코드: 퍼미션(권한) 허용하지 않음을 나타내는 코드.
- 500 상태코드: 서버프로그램 오류(JAVA,JSP,PHP,닷넷ASPX)


### 20200911(금)
- 만약 여러분 스마트폰을 디버그용으로 사용하는 상황이 되시면,
- 다음주에 저와 같이 스마트폰을 디버그용으로 변경처리해서 스마트폰으로 진행하도록..
- 디스사이즈 설정 : 콘텐츠가 화면 크기에 맞춰서 자동 리사징됩니다.
- 서머리: 이전까지 설정한 내용 확인 하는 화면
- 학생들 중에서 화면 오른쪽에 빨간색으로 HAAX Install 항목 나오시는 분 조사.
- 가짜 스마트폰을 만드려면 가상화가 필요합니다. -> 컴퓨터 전원넣을때
- F2 / Del 눌러서 바이오스 화면으로 진입 후 CPU Configuration 메뉴에서 VT-x Enabled.
- 구글링해서 VT-x Enabled 검색.
- AVD 가짜 스마트폰 만드는 중... 롤리팝(안드로이드 OS==System Image)
- <c:out -> jstl core prefix접두어 <c:
- Root(출력단최상위).layout(폴더).파일명(activity_main.xml)
- 넥서스One 모델을 가상장치(애뮬레이터)로 만듭니다.- 이미지선택(OS선택) 안드로이드OS선택
- 가상장치 사양(메모리,하드디스크등) 정하는 화면 입니다.
- 액티비티 = 화면 = MainActivity.java(백단)-매칭-activity_main.xml(프론트단)
- 테스트하시는 폰이 구형폰이면 버전 하한선 이상이 되어야 실행이 가능합니다.
- 안드로이드 스튜디오 2.3.3(2016년) -> 4.0.1(2020년) 버전 변경합니다.
- AVD(안드로이드 버추어 디바이스) 스마트폰없이 실행환경 만드는 장치.
- 오후 관리단 게시판 웹에디터 붙이도록 하겠습니다.
- 애플리케이션 테스트 수행 과목 진행.(완료보고서용 엑셀, 인수테스트용 매뉴얼) 2가지문서
- 문서작업 초기엔 제가 같이 합니다. 이후 상세내용은 여러분들이 작업진행.

- board_view.jsp 파일 엽니다. -> textarea 태그를 찾습니다.
- textarea 태그 찾아서 class 명에 ckeditor 을 추가해 주시면 끝
- board/board_write.jsp 파일 수정.
- LICENSE.md 에 라이센스 정보: GNU, LGPL 공개소프트웨어입니다.
- src/main/webapp/resources/plugins폴더안에 붙어 넣을 겁니다.
- plugins폴더에는 AdminLTE가 사용하는 부트스트랩, 챠트 등등 자바스크립트 프로그램이.
- ck에디터는 자바스크립로 만들어져 있습니다.(tiny에디터, 네이버 스마트에디터2)
- 소스를 복사 붙여넣을 위치는 AdminLTE가 있는 위치에 붙여 넣으시면 됩니다.

### 20200910(목)
- 애플리케이션 테스트 수행 과목 진행.(완료보고서용 엑셀, 인수테스트용 매뉴얼) 2가지문서
- 문서작업 초기엔 제가 같이 합니다. 이후 상세내용은 여러분들이 작업진행.

- IT강의저장소>v12.0.0>애플리케이션테스트수행> 작업했던 스프링 프로젝트기준으로 제작
- 인수테스트용 매뉴얼 pptx(프레젠테이션) + 완료보고서용 아키텍져(설계서)제작 xlsx(엑셀)
- 노드MCU(아두이노)실습에 필요한 자재는 아래와 같습니다.(총 7860원 + 배송비 2500 필요)
- 실습용 점퍼선 암-암 10Cm 40핀(2셋) = 5000원 주문필요 합니다.(아래 URL)
- http://www.eduino.kr/product/detail.html?product_no=88&cate_no=51&display_group=1
- 실습용 LED(20개)+추가구성품항목 저항220옴10pcs(2셋) = 2860원 주문필요 합니다.(아래 주문URL)
- http://www.eduino.kr/product/detail.html?product_no=202&cate_no=51&display_group=1

- http://cafe.daum.net/human20 : 
- 4교시 줌에서 시험 보시는 상황 -> 카메라 항상 켜두셔야 합니다.
- 왜냐하면 줌 녹화기능으로 녹화하게 됩니다.
- 4교시에 제출하실 파일 4개(아래)
- 1.애플리케이션 설계 평가자체크리스트001.bmp
- 2.애플리케이션 설계 서술형평가지001.bmp
- 3.애플리케이션 설계 사후평가001.bmp
- 4.develop_report.pptx

- 5교시에 제출하실 파일 1개(아래)
- 애플리케이션 테스트 수행 사전평가_5교시.bmp

- src/main/webapp/WEB-INF/jsp/admin/include/footer.jsp 에서 로그아웃 링크 값 수정OK.
- AdminLTE 관리자단 로그아웃은 jsp단 a링크값 /tiles/logout.do 변경처리 OK.
- 초기에 http://~~~/sht_webapp/tiles/main.do;jsessionid=B1DB2C5BED2E46005D8F3B85381AAAD9
- 초기 웹페이지 접속시 발생하는 세션은 톰캣WAS(웹애플리케이션서버)에서 발생시킵니다.
- 만세아이콘(mysql)실행
- 로그인 실패시 에러 메세지 출력하는 message 변수 처리하는 부분. login.jsp에서 확인 OK.

### 20200909(수)
- a태그에 전송 자바스크립트 추가.(기존jsp내용 복사)
- jstl prefix(접두어), suffix(접미어), 보안전송때문에 jstl <form:form> ~ </form:form> 사용
- input type name 값 추가.
- input type hidden 값 기존jsp에 있는 내용 복사 -> 신규jsp 붙여넣기.
- 기존 전자정부용 로그인 폼 엽니다.
- src/main/webapp/WEB-INF/jsp/cmm/uat/uia/EgovLoginUsr.jsp
- login.jsp 프로그램 입힙니다.
- login.jsp 만드실 겁니다.(login.hmtl 디자인을 가지고 만듬)
- HttpServletRequest클래스(웹용통신http을사용하는, 서버프로그램Servlet에서, 요청Request 받는것)
- 기존 로그인 컨트롤러참조 위치(아래)
- src/main/java/egovframework/let/uat/uia/web/EgovLoginController.java
- jsp 파일에서 컨트롤러에서나 사용했던 자바코드를 사용하고 있습니다.
- <%@ page import ="egovframework.com.cmm.LoginVO" %>
- [if <= IE 9] ~ [endif]
- src/main/webapp/home/index.html 파일을 아래 4개의 파일로 분리하게 됩니다.
- layout.jsp(템플릿:header.jsp + main.jsp + footer.jsp)
- layout.jsp 수정중...<body>태그 위에 삭제.
- 디자이너가 만든 home폴더를 전자정부 프로젝트의 webapp폴더에 붙여넣습니다.
- 이유는 개발자가 위 html을 jsp 변경하기 위해서...
- @Resources -> @Inject(@Autowired) 변경.
- 리뉴얼시 기존 전자정부프레임워크를 소스를 수정하시면 않되는 이유는
- 버전 업데이트 되었을때, 신규버전으로 덮어써야 되는데, 
- 우리가 신규로 수정한 내용은 없어지게 됩니다. 방지하려고, 분리하는 겁니다.
- /tiles/main.do 신규디자인이 적용될 컨트롤러를 edu패키지로 분리합니다.
- 신규패키지명은 edu.human.com.tiles.web 생성. TilesController클래스 생성.
- 전자정부-egov 프로젝트 사용자단 리뉴얼(결과예상:https://egov-start.herokuapp.com/)
- 메인페이지만 타일즈 레이아웃 템플릿 사용중 -> 신규 디자인으로 리뉴얼 합니다.
- 만세아이콘 실행.
- 스프링-mysql 프로젝트에 SNS로그인 기능추가(네이버API사용)-OK.
- 어제 작업한 HomeController 클래스 내용중 @Inject 추가한 부분 복사해서 지금작업부분에 붙여넣기
- 어제 작업한 HomeController 클래스 내용중 /login, /login_callback 2가지 부분 복사해서
- 오늘 작업하는 프로젝트에 붙여넣기.
- 어제 작업한 NaverLoginController 클래스 복사 지금 작업하는 프로젝에 붙여넣기
- 어제 작업한 NaverLoginApi 클래스 복사 해서 지금 작업하는 프로젝트에 붙여넣기
- pom.xml 내용추가: 외부라이브러리사용(네이버,파싱 모듈 2가지)
- 오늘작업-후배작업
- 어제작업-선배작업
- 스프링mysql프로젝트 오픈해 주세요...
- 파스타 배포는 오프라인(교실)수업시 같이 하겠습니다.(포트폴리오로 망치실까봐,사전방지)
- 만세아이콘 실행

### 20200908(화)
#### 미처리 작업내역
- 애플리케이션 설계 pptx문서 + 서술형 시험준비(오후1시간정도)
- 스프링-mysql 프로젝트에 SNS로그인 기능추가(네이버API사용) 후 파스타에 배포(시간이되면)
- 전자정부-egov 프로젝트 사용자단 리뉴얼(시간이 되면)
- 안드로이드 스튜디오에 AVD(가상애뮬레이터) 추가한 후 HelloWorld 실행
- 내일 AVD시도 한번 해보고 시간이 오래 걸리는지 확인 하겠습니다.

- 처리OK.스프링-hsql 프로젝트 스프링시큐리티에 덧붙여 SNS로그인기능추가(네이버API사용)
- 코딩순서: 
- -> NaverLoginApi클래스(네이버제공) -> NaverLoginController(네이버제공-인증키)
- -> HomeController(개발자제공-앞의2개클래스사용)
- 이니시스 또는 LG데이콤, KCP 에서 제공하는 결제모듈도 지금 우리가 사용하는 방식과 같습니다.
- 네이버아이디로그인에서는 URL http://localhost 않쓰고, http://127.0.0.1:8080 사용합니다.
- 이클립스에서 학생명스프링프로젝트 오픈 합니다. 여기다 네이버 ID로 로그인 만듭니다.
- login_callback 에서, 인증 success 후 네이버로그인API 리턴값을 세션변수로 만듭니다.
- 개발자가 할일은 login_callback 콜백URL에 스프링 시큐리티와 연동시킵니다.
- OAuth2.0(Open Authenticataion 오픈인증)
- 토큰(전송된인증데이터) 발급
- 이클립스포톤버전(전자정부개발환경3.9-레거시스프링에서 주로사용=현업용) 
- == 스프링툴슈트(STS-스프링부트에서 주로사용-교육용), 아파치톰캣
- 톰캣에서 실행되는 java 작은프로그램들 servlet(서블렛 server + let)이라고 합니다.
- 아울렛(outlet) - 전시매장
- 개발언어 및 기술: ... EL(예, ${url}=컨트롤러에서 변수를 지정해서 jsp로 보내는 값출력
- Express Language(jsp표현언어) -> 기능확장시 jstl 됩니다.
- 아래까지 하셨으면, 네이버 로그인 API 사용준비는 되었습니다.
- 애플리케이션 정보화면에서 ClientID와 Client Secret 항목 내용복사->java프로그램에 필요
- 로고이미지는 네이버 로그인 창에 누가제공하는 건지 이미지로 표시가 가능하 합니다.
- /login (스프링시큐리티+네이버로그인) 콜백URL에서 차이점 나타남.(아래)
- 스프링시큐리티 : /login_success
- 네이버로그인API: /login_callback
- 콜백URL(콜백함수): 호출없이바로실행 == 인증 success 받은 이후에 이동할(실행할) 주소. 
- 서비스URL: 이클립스개발환경(http://localhot:8080/login == http://127.0.0.1:8080/login )
- 위 URL에 [네이버ID로 로그인] 버튼만듭니다.

### 20200907(월)
- 액티비티(Activity) - 활동 - 앱화면을 지칭합니다.-> MainActivity 진입점.(activity_main)
- MainActivity.java(자바프로그램)<-데이터->activity_main.xml(화면-jsp와 같은 역할)
- AppCompat: 안드로이드 라이브러리 프로그램들 > MainActivity extentds AppCompat
- 우리는 지금 버전 2.3.3 개발환경 -> 최근버전은 4.0 개발환경 까지 나와 있습니다.
- 자바기반- 프로그램 확장자 .java (기반으로 작업예정 입니다.)
- 코틀린 언어로 하시는 분도 있습니다.- 프로그램 확장자 .kt
- 조금더 진행 하겠습니다.
- AVD 가상장치(실제 스마트폰 없이, 앱을 실행하는 방식) 사용을 해 보겠습니다.
- 여러분 PC(노트북)상태에 따라서 않되는 경우도 있습니다. 되는지 확인해 보겠습니다.
- 실행 초기엔 ...Wizard 마법사창이 나오는데요. cancel로 취소하시면, 
- 위 공유화면처럼 나온 Android Studio Version 2.3.3 이 나오면 맞습니다.
- 여러분 댁의 PC(노트북)에 안드로이드스튜디오 실행환경 안되시는 분 손.(5명)
- 구글 드라이브에서 다운로드 받으시고, 압축 푸시고, 실행 해 주시면 됩니다.
- 실행 않되시는 분만 팀뷰어로 봐드리겠습니다.
- 댁 PC(노트북)에 안드로이드스튜디오 다운 받아 주시기 바랍니다.
- 애플리케이션 설계 pptx문서 마무리.(이번주 목요일 애플리케이션 설계시험=과제물+서술형)
- admin/board/list, view, insert, inser_reply 파일 만들었습니다.
- 과제물 제안요청서 pptx파일 리뷰.OK
- 전자정부 프로젝트 AdminLTE용 답글쓰기(계층형게시판) 기능 추가.OK
- 계층형 게시판(답변게시판) <-> 이전 스프링 mysql프로젝트에서 했던 댓글게시판과는 틀림.
- 댓글 게시판 SNS 유행하면서 나타난 게시판 입니다.
- 계층형(계단형)게시판은 20년전 부터 나온 오래된 기술 입니다.
- 우리가 헷갈린 이유는 view파일을 (view+update 기능을 1개로 합침-AdminLTE프로젝트에서)_
- view 파일 이후 화면들에서 수정한 사항들이 필요했습니다.
- 답변 로케이션 변수값=들여쓰기 위치값 변화확인: 최초0->첫번째답글1->두번째답글2
- 확인: 답변들여쓰는 ANSWER_LC=replyLc (Location) 값으로 들여쓰기 위치 지정.
- 확인: sortOrdr라는-파라미터 답변에대한 플래그값으로 사용, view.jsp-이 플래그가 없어서 않됨.
- addReply.do(입력폼출력), insertReply.do(실제DB입력액션) 2개로 나뉘어짐.
- 답변게시판 입력에서 필요한 필드(아래)
- 1.replyAt(답글플래그값), parnts(부모게시물id값), nttId(현재게시물Id)
- insert.jsp 복사해서 insert_reply.jsp 만들겁니다.
- 필요한 내용은 flag(깃발-방향표시/신규인서트인지,답글에대한 인서트인지 구분자로 flag사용)
- 애자일 개발방법론: 테스트 주도 개발.
- 프로젝트를 단위로 분리한 후 단위별개발하고->테스트->피드백->부족부분 재개발)
- 애자일 수행방법: 
- 익스트림 프로그래밍(2인1조 방식)
- 스크럼 방식(10명이내 1팀 단위개발-피드백-재개발 반복).
#### 스프링프레임워크의 특징
- jsp / Velocity = tiles(타일즈) = jsp 레이아웃 템플릿
- ORM: Object Relation Mapping ( 마이바티스 매퍼mapper과 같은 것)
- 클래스(Object) 와 DB 관계(Relation)을 매칭시켜 주는 기능(마이바티스 Mapper)
- MVC 기능.
- AOP(관점지향프로그래밍) = 인터셉터 기능.
- IoC(제어의 역전-개발자가 프로그램라이프사이클을 제어하는것이 아니고, 
  스프링이 프로그램라이프사이클을 제어한다.)
  위에서 프로그램라이프사이클이란 프로그램 메모리에 탑재(실행), 메모리에서 제거(종료)와
  같은 상화을 개발자가 코딩으로 제어하는 것이 아니고, 
  스프링이 메모리에 올리고, 제거하는 제어를 하는 것을 제어의역전IOC(Inversiton of Control)

- 1티어: 서버1대(Db-Model+웹서버-View+톰캣서버-[Controller+jsp서버])
- 2티어: 서버2대(1대:DB, 1대:아파치웹정적서버+Was동적서버)
- 3티어: 서버3대(1대:DB, 1대:아파치웹정적서버, 1대:Was동적서버)
- 3티어: [UI프런트엔드단 + WAS(웹어플리케이션서버)] + DB서버
- 3티어: 클라이언트(뷰단) + 애플리케이션티어(컨트롤러+서비스) + 데이터티어(DB단)
- 제안요청서인데, 프로젝트도 시작하기 전에 메인페이지가 나올수 가 있을까?
- 메인페이지 시안 포토샵으로 만들어서, 코딩에 적용하게 됩니다.
- 전자정부프로젝트에서 Ajax기술(RestAPI)적용된 부분은 관리자관리>회원아이디중복체크에 적용.
- 조달청(관공서, 대학, 중고등학교) 위 CMS(전자정부프레임웍기반) 다 가져갑니다.
- PHP 사이트들은 워드프레스, 그누보드, 제로보드기반의 사이트+쇼핑몰 웹에이전시 에서 가져갑니다.
- 줌 로그인하실때, 구글계정으로 로그인 가능 = oAuth2.0 인증절차를 개설했기때문에 가능.
- 가능하면, 스프링 Hsql프로젝트에 스프링시큐리티로 로그인체크 에 더해서 + ,
- 가능하면, oAuth (구글API사용)인증으로 로그인체크를 할 수 있었으면(희망사항) 합니다.
- 위에 적어놓은것이 일명 SNS인증, 요즘 프로젝트에 대부분 적용하고 있음.
- 멀티사이트가 무엇인지 납품결과로 알려 드릴께요(CMS 에서 말하는 멀티사이트란)
- 멀티사이트 사용처(1개의 관리자에서 여러 도메인/사이트를 제어- 다국어사이트에서 사용됨)

### 20200904(금)-아래
- view.jsp 에서 파일다운로드 기능 사용하기 위해서 수정한 파일명은
- src/main/webapp/WEB-INF/jsp/cmm/fms/EgovFileList.jsp 에서 <a 링크 부분 추가 처리.
- 첨부파일 있을때, 수정시 에러 발생(다운로드 부분때문에)
- 왼쪽메뉴 active 풀리는 것 방지용 수정: footer.jsp 하단 var current = '${bdMstr.bbsId}';
- 예전 오라클프로젝트(HomeController클래스)에서 게시판 타입을 셋션으로 처리
  session.setAttribute("세션게시판_변수네임", "값변수");//세션변수 생성
  session.getAttribute("세션게시판_변수네임");//세션변수 보기
- insert.jsp 파일에서 fn_egov_addBoard() -> fn_egov_insertBoard() 변경.
- src/main/java/egovframework/let/cop/bbs/web/EgovBBSManageController.java 파일 참조.
- addBoard(입력화면) , insertBoard(DB입력처리) 기존 2개로 나누어짐.
- insertBoard(입력화면), addBoard(DB입력처리) 우리것을 위 기존 네이밍으로 변경처리.
- 파일위치: src/main/webapp/WEB-INF/jsp/cop/bbs/EgovNoticeRegist.jsp
- EgovNoticeRegist.jsp 이파일에서 hidden값을 insert.jsp로 가져옵니다.
- 코드 인스펙션(소스 분석)_다른 솔루션 분석할때 사용하는 방법.
- BoardController.java 클래스에 매핑추가.
- 경로를 만들었으면, 매칭되는 View(jsp)와 매칭시키는 것을 = @Requestmapping(컨트롤러추가) 
- 게시판 생성 버튼 클릭 처리. 매개변수=파라미터=인자=쿼리스트링=질의문자
- 9월17일 부터는 보드(노드MCU-C언어)+라즈베리파이(Raspberry Pi-gcc사용) 사용 고민됩니다.
- 게시판관리 메뉴 분리 후 2개 모두 선택문제 처리(JQuery로 문제점 처리) 유지보수 비용
- 기존 공지사항/갤러리 관리로 메뉴를 분리처리.
- 전자정부 프로젝트 AdminLTE 신규게시물생성, 답변게시물생성까지 작업 예정 입니다.
- it강의 저장소의 애플리케이션 설계의 구글 프레젠테이션 문서도 변경 했습니다. 이용하셔도 됩니다.
- 학습목차에 올려놓은 사항은 지웠습니다.
- 작업기준은 아래 변경된 문서로 작업 하시면 됩니다.
- 구글 프레젠테이션 문서 변경했습니다.-> 변경 한 것으로 작업해 주세요...
- 변경한 파일 위치는 it강의 저장소 > 학습목차 제일하단에 다운로드 할 수 있습니다.
- 데이터전송관련된: Soap 프로토콜, Http 프로토콜
- RestAPI설계문서 작업은 예전 했던 화면에 보이는 OpenApi.java 프로그램을 기준으로 함.
- 개발자라고해서 꼭 코딩만 하지 않습니다. 위 화면처럼 지루한 문서작업도 합니다.
- 전산화=SI업체가 하는일 = 오프라인 작업 -> 온라인으로 변경하는 주 작업.
- 전자정부 프로젝트 공통모듈 > 일정관리 기능 3가지 ( 월별, 주간별, 일별 일정보기 )
- 오프라인 일정관리(엑셀,프린트종이,벽에거는 화이트보드) -> 온라인 일정관리로 변경
- 다음주 월, 요구사항 확인(제안요청서pptx) 잘하신 분들 리뷰예정.
- 전자정부 프로젝트 공통모듈 > 배너관리 기능(CRUD) > 배너새성, 조회, 수정, 삭제
- MVC구조란 ( Model:데이터베이스, View: jsp화면, Controller: Model단과 View단 매칭)
- @애노테이션 클래스종류: @Controller, @Service, @Repository, @Inject, @Resources, @Autowired ...

### 20200904(금)-아래
- view.jsp 에서 파일다운로드 기능 사용하기 위해서 수정한 파일명은
- src/main/webapp/WEB-INF/jsp/cmm/fms/EgovFileList.jsp 에서 <a 링크 부분 추가 처리.
- 첨부파일 있을때, 수정시 에러 발생(다운로드 부분때문에)
- 왼쪽메뉴 active 풀리는 것 방지용 수정: footer.jsp 하단 var current = '${bdMstr.bbsId}';
- 예전 오라클프로젝트(HomeController클래스)에서 게시판 타입을 셋션으로 처리
  session.setAttribute("세션게시판_변수네임", "값변수");//세션변수 생성
  session.getAttribute("세션게시판_변수네임");//세션변수 보기
- insert.jsp 파일에서 fn_egov_addBoard() -> fn_egov_insertBoard() 변경.
- src/main/java/egovframework/let/cop/bbs/web/EgovBBSManageController.java 파일 참조.
- addBoard(입력화면) , insertBoard(DB입력처리) 기존 2개로 나누어짐.
- insertBoard(입력화면), addBoard(DB입력처리) 우리것을 위 기존 네이밍으로 변경처리.
- 파일위치: src/main/webapp/WEB-INF/jsp/cop/bbs/EgovNoticeRegist.jsp
- EgovNoticeRegist.jsp 이파일에서 hidden값을 insert.jsp로 가져옵니다.
- 코드 인스펙션(소스 분석)_다른 솔루션 분석할때 사용하는 방법.
- BoardController.java 클래스에 매핑추가.
- 경로를 만들었으면, 매칭되는 View(jsp)와 매칭시키는 것을 = @Requestmapping(컨트롤러추가) 
- 게시판 생성 버튼 클릭 처리. 매개변수=파라미터=인자=쿼리스트링=질의문자
- 9월17일 부터는 보드(노드MCU-C언어)+라즈베리파이(Raspberry Pi-gcc사용) 사용 고민됩니다.
- 게시판관리 메뉴 분리 후 2개 모두 선택문제 처리(JQuery로 문제점 처리) 유지보수 비용
- 기존 공지사항/갤러리 관리로 메뉴를 분리처리.
- 전자정부 프로젝트 AdminLTE 신규게시물생성, 답변게시물생성까지 작업 예정 입니다.
- it강의 저장소의 애플리케이션 설계의 구글 프레젠테이션 문서도 변경 했습니다. 이용하셔도 됩니다.
- 학습목차에 올려놓은 사항은 지웠습니다.
- 작업기준은 아래 변경된 문서로 작업 하시면 됩니다.
- 구글 프레젠테이션 문서 변경했습니다.-> 변경 한 것으로 작업해 주세요...
- 변경한 파일 위치는 it강의 저장소 > 학습목차 제일하단에 다운로드 할 수 있습니다.
- 데이터전송관련된: Soap 프로토콜, Http 프로토콜
- RestAPI설계문서 작업은 예전 했던 화면에 보이는 OpenApi.java 프로그램을 기준으로 함.
- 개발자라고해서 꼭 코딩만 하지 않습니다. 위 화면처럼 지루한 문서작업도 합니다.
- 전산화=SI업체가 하는일 = 오프라인 작업 -> 온라인으로 변경하는 주 작업.
- 전자정부 프로젝트 공통모듈 > 일정관리 기능 3가지 ( 월별, 주간별, 일별 일정보기 )
- 오프라인 일정관리(엑셀,프린트종이,벽에거는 화이트보드) -> 온라인 일정관리로 변경
- 다음주 월, 요구사항 확인(제안요청서pptx) 잘하신 분들 리뷰예정.
- 전자정부 프로젝트 공통모듈 > 배너관리 기능(CRUD) > 배너새성, 조회, 수정, 삭제
- MVC구조란 ( Model:데이터베이스, View: jsp화면, Controller: Model단과 View단 매칭)
- @애노테이션 클래스종류: @Controller, @Service, @Repository, @Inject, @Resources, @Autowired ...

### 20200903(목)-아래
- 이론예정: 전자정부 일정관리 기능(모듈) 기능 상세명세 확인 + 기능유형이름 확인.
- 이론예정: 모델2 의 MVC에 대해서 확인.
- 이론예정: MVC기반의 애노테이션 종류 확인.
- 내일은 전자정부 프로젝트 AdminLTE 신규게시물생성, 답변게시물생성까지 작업 예정 입니다.

### v11 애플리케이션 설계 수업진행은 아래 2가지로 진행.

#### 1. 아래쪽은 문서화 작업.
- 타 시스템 연동: Hrd-Net API이용해서, 구직자 훈련과정 콘솔창에 출력하는 자바프로그램 제작했습니다.
- 위 작업 URL: http://www.hrd.go.kr/hrdp/ap/papco/PAPCO0700T.do
- 타 시스템 연동했던 프로그램을 문서화하는 작업이 이전 주(40시간) 메인작업 내용내용.
- 문서작업시 Rest Api Status code 내용 기록.
- 이클립스에서 소스위치: 프로젝트명/src/test/java/kr/or/test/OpenApi.java 참조.

#### 2. 아래쪽은 이론 서술형 내용.
- 공통 모듈 인덱스 및 기능 코드 설계. 전자정부 개발버전 3.9버전 상세 가이드>
- 정보제공/알림>배너관리>배너관리 기능설명(CRUD), 
- 배너관리에서 관련소스 유형(Controller, Service, ServiceImpl, Model, VO, DAO, xml쿼리)
- 공통컴포넌트란? 업무처리로직에 +관리자관리모듈 +게시판관리모듈 레고블록처럼 추가 개발.
- 공통컴포넌트(모듈) 중에 게시판관리 변경(삭제부분-완전삭제로 변경), 관리자관리 기능 추가.
- 3-1프레임워크적용방안>아키텍처 규칙
- Annotation(애노테이션기반)@-스프링MVC준수: @RequestMapping(URL 매핑처리)
- 대표적인 애노테이션 클래스: @Controller, @Service, @Repository
- 확장 = extends = 상속 같은 의미, 다른말.
- 지금 우리가 개발하는 전자정부 프로젝트는 연계구축에 해당됩니다.
  통합DB(전자정부-ibatis,AdminLTE-mybatis) 때문에 지금 작동됩니다.
- 참고자료문서에서 
- 2-6프레임워크구성>최적의 공통컴포넌트 개발을 위한 필요조건(아래)
  1)UML기반산출물표준화+2)명확하고알기쉬운설계+3)재사용이쉬운설계(클래스사용)
  +테스트기반의개발(애자일)+생명주기기반의서비스제공

- 재사용성 확보하기 위한 공통모듈: 전자정부 프로젝트의 게시판, 일정관리, 회원관리
- UML(유니버셜 마크업 랭귀지): 유스케이스때 사용된 액터 같은 기호(예,졸라맨)를UML이라고 함.
- 오후는 애플리케이션 설계 과목 입니다.
- 시험 보시느라 수고 많으셨습니다.^^
- 4교시 시험 시작 합니다.(이미지수정시 서명란 입력 부탁드릴께요)
- 제출물은 평가자체크리스트이미지+사후평가이미지+과제물pptx파일+시간.jpg

- xml쿼리-서비스(DAO)-현재컨트롤러에서 실행처리-@Inject 인스턴스변수 생성 후 호출OK.
- 전자정부프로젝트인증조건 extends상속 EgovComAbstractMapper필수
- 임플리먼트 패키지 안쪽에 DAO클래스(@Repository포함)생성.
- 인터페이스 만드신 후 임플리먼트 패키지에 BoardServiceImpl클래스 생성.
- 서비스클래스에 @Service 애노테이션을 붙이면, 스프링빈으로 등록
- 서비스패키지 만듭니다. du.human.com.board.service->인터페이스생성
- 쿼리가 완성 되었으니, 자바폴더에서 서비스(DAO포함)만듭니다.
- 테이블명 대문자로 해 주세요(영역지정후 Ctrl+Shift+X 대문자로)
- mapper폴더안에 board폴더 생성 후 board_mysql.xml삭제쿼리 생성
- xml쿼리생성(mybatis사용)-DAO생성-Service생성-현재컨트롤러 수정
- 이후 기존코드유지 후 새 코드 작성
- BoardController클래스 엽니다.
- 전자정부 프로젝트 AdminLTE게시판 삭제 기능 마무리


```

20200902(수)
- AdminLTE용 게시물 생성 기능 추가 합니다.(앞으로 v11애플리케이션 설계 시간 설계내용으로 실습예정)
- AdminLTE용 게시물 삭제 기능 추가 합니다.(오늘은 기존 삭제 기능 까지_앞으로 신규 완전삭제기능으로 추가)
- AdminLTE용 파일 다운로드 링크 추가 합니다.(EgovNoticeInqire.jsp 179라인)
- 기존 삭제 컨트롤러 참조: EgovBBSManageController
- 관리자삭제: 완전하게 게시판 레코드를 삭제처리.
- 기존삭제: 기존-필드USE_AT 값을 N 으로 변경해서 삭제처리.
- flag(깃발) 달면 되지 않을까요?
- EgovNoticeUpdt.jsp 파일(기존egov파일) 참조: 하단 Js부분 복사
- 작성자는 필수 입력값 입니다. list.jsp에 있는 frstRegisterNm 복사합니다.
- form name="frm" -> "board" 로 변경
- readonly(폼전송에 포함), disabled(폼전송에서 제외)
- let(Light Enviroment Template):경량 환경 템플릿 약자
- 유효성 검사 항목을 분리처리( EgovNoticeRegist.xml파일 )
- 전자정부 프로젝트 유효성 검사에 사용되는 설정파일 확인(게시판유효성)
- 오전 수정 버튼 클릭시 작동않되었습니다. 이유는 input 태그에 name값이 없어서 입니다.
- view.jsp 파일, BoardController.java파일 2개 파일 수정했습니다.
- 업데이트에러 인데, 뭐가 누락되서 에러 나오는지 확인에 필요한
- 외부 라이브러리 사용 준비중...
- 유효성 검사때문에 수정.
- 기존 업데이트페이지명 EgovNoticeUpdt.jsp
- 2개의 페이지를(뷰+수정) -> 1개로 변경중(수정페이지 1개로)
- form 속성중에 multipart 부분이 누락되어서 않됨.
- <form></form> 변경: <form:form></form:form> 폼전송시 보안처리
- XSS(크로스사이트스크립트) 방지(해킹코드방지) 실행해킹코드를 
  실행불가능한 일반문자로 변경처리
- 이전 작업한 스프링 프로젝트에서는 redirect: 페이지 이동경로
- 전자정부 프로젝트는 forwoard: 페이지 이동경로
- 기존 컨트롤러 이용: egovframework.let.cop.bbs.web 패키지
- 참조 컨트롤러명: EgovBBSManageController.java
- 이전 스프링 프로젝트는 수정을 별도의 페이지로 구성하였으나,
- 전자정부 프로젝트는 수정을 보기페이지와 같이 사용하도록 처리.
- 위 처리 내용 2가지 제목/내용 readonly 제거,작성자값 ntcrNm 변경
- 전자정부 프로젝트 실행-브라우저
- 에러 상화 처리 확인

### 20200901(화) 
- 리스트에서 답글 표시 하는 방법(계단식)
  EgovNoticeList.jsp 참조.
- 답글 게시판의 로직은 스프링 코딩 상관없이 
  SQL 쿼리에서 해결하는 겁니다.- 5년-10년 전에는 게시판 과목
  제일 마지막 부분 답글게시판 이었습니다.
- 메서드-Method(자바에서 호칭 함수), 함수-Function(C언어/자바스크립트에서 사용)
- @ModelAttribute("searchVO") BoardVO boardVO 
  1. 컨트롤러가 받는 변수는 boardVO 확인 OK,
  2. jsp 로 보내는 변수는 searchVO 확인 OK.
- 이전 관리자기능은 전자정부에 없었기 때문에 우리 맘대로 만들었다면,
  지금 작업하는 게시판관리 기존전자정부에 있기 때문에 기존 규칙을 따른는 것이 안전함.
- 요구사항: 기존문제점-관리자단,사용자단 짬뽕 -> 개선사항: 관리자단/사용자단 분리 처리.
- 파일이름으로 검색할때 단축기 : Ctrl+Shift+R 조합 => Open Resource 창 띄우기
- 이전 스프링 프로젝트 만들때, 기본CRUD 만들고(Board), 추가한부분(BoardVO) = 검색기능+페이징기능
- BoardVO클래스(자식) > Board클래스(부) = 부모+자식 포함된 모든 변수(get,set) 다 사용.
- 학생들은 요구사항 확인 제안요청서 ppt 문서 계속 입력해 주시기 바랍니다.
- 부트스트랩 JQuery 그리드시스템 사용 가로 12개 = 6개 + 6개 분리(50%:50%)
  그리드 JQuery는 자동 계산식이 들어가 있습니다.col-4라면, 화면이 3개로 분할됨
  <div class="col-4" /><div class="col-4" /><div class="col-4" />
  33.3333% + 33.3333% + 33.3333% = 100%로 처리(반응형처리 됨)
  그리드(격자,모눈종이 12개 가로 칸을 가지는 모눈종이) 12개 가로화면 분할
- placeholder 옵션은 입력 힌트로서 회색으로 표시됩니다.
- 호출하는 곳은 list.jsp 에서 호출(링크)
  지금까지 작업내용 확인, 브라우저에서...
- BoardMasterVO master = new BoardMasterVO();//인스턴스 클래스변수 만들기.
  Get,Set 사용하기위해서 인스턴스ㅡ 변수 만든이유 입니다.
- 기존 패키지에서 egovframework.let.cop.bbs.web >
  EgovBBSManageController.java > > selectBoardArticle.do 매핑값 복사 196라인 참조
- 기능별로 나눠져 있는 방식을 따라서 edu.human.com.board.web 패키지에 추가.
- view.jsp 디자인 확인: 컨트롤러에서 @RequestMapping 경로 추가...
- 카드 클래스 : card 웹 프로그램에서 최초로 사용하던곳 쇼핑몰에서 상품을 겔러리 형식으로
                표시할때 사용하던 방식.(카드방식)
- 이클립스 작업은 여기까지 하시고, ppt 제안서 작성을 진행 하시기 바랍니다.
- 게시판 상세보기 화면 만들고, 프로그램 입히기 작업진행 중...
- 기존프로젝트에서 board_view.html 파일 찾아서 테이블 디자인 입히기.
- 이클립스 내장된 브라우저는 이쁘게 나오지 않습니다.(크롬에서 보시면 정상으로보임)
- 1. 전자정부 프로젝트 제안요청서 계속 작성
- 2. 전자정부 프로젝트 이클립스 띄워서 지금까지 작업물 확인(아래)
     AdminLTE 관리자단 > 게시판관리 > 검색어(공지1) 로 검색해서 1개 출력

```

#### 전자정부 프로젝트 제안서 작성방법

- 36. 납품완료시 : 전자정부 프로젝트 소스 + ERD + 테이블정의서 + 매뉴얼 + 사이트배포 내용을 DVD로 구워서 고객사에게 전달해주어야 합니다.

- 35. 구글 ppt문서에서 [***학생이 작성] 부분은 학생이 작성하는 부분 입니다.
    
 ```   
    애자일 프로그래밍의 대표적인 방법 2가지
    - 익스트림 프로그래밍 : 구글 (2인1조 프로그래밍)- 1개소스를 2명이 작업하는 방식.
    - 스크럼방식 : 쉽지가 않습니다.(8명정도 모아놓고, 1개 프로그램을 진행)
  하다보면 1인 주도 개발이 됩니다.
```
- 34. 애자일(Agile) -  테스트주도(TDD) 개발 방법론: Hot 유행어

```
    단위프로그램개발 -> 테스트 -> 피드백 -> 수정 -> 테스트 -> OK -> 다음 단위프로그램개발
```
- 33. Mysql의 특징

```
    관계형데이터베이스-RDBMS, 오픈소스(단, 커뮤니티버전), Ansi(표준)-SQL사용,
```
- 32. 스프링 웹프로그램 실행모델

```
    위 이미지 부분를 다른 이미지로 대체.
    디스패쳐서블렛: 서블렛(자바프로그램)배치 = 스프링폴더> context-servlet.xml
    (뷰리졸버-뷰단jsp해석기 포함)
```
- 31. 스프링프레임워크란?

```
    특징을 기록(MVC사용, 오픈소스, DI(인젝션사용), AOP(인터셉터사용), OOP(클래스사용)
    서블렛(10년전+고전클래스-오리지널 자바로) 
       -> 스트럿츠(5년전+OOP클래스) -> 스프링(현재+MVC+DI+AOP)
```
- 30. 우리가 리뉴얼하는 전자정부-egov프로젝트는 오픈소스 입니다.(무료배포)

```
    사용자/개발자 입장에서 돈 투자없이 시간만 들이면, 상품이 만들어 집니다.
    자본없고, 사람있고, 기술있는 우리나라에서는 괜찮은 수익 창출 방법 입니다.
    그래서, 오픈소스를 사용한 컨버전스(융합) 기술이 대세입니다.
    우리반이 디지털 컨버전스(융합)반 - 오픈소스 사용이 대세 입니다.
    오픈소스 돈 버는 방법: 작업 대행해 주는 방법으로 수익을 창출합니다.
    오픈소스로 만들어진 프로그램은 무료(돈받고 팔 수없습니다.) 단, 작업비는 받을 수 있다.
```
- 29. 산업표준을 지향: 애플, MS, 오라클, 구글 = 본인이 표준이 되면, 돈이 됩니다.
- 28. 3티어 구조:

``` 
    소프트웨어 단 : Model(Db) - View(화면) = 2티어 구조
                    Mode(DB) + Controller(URI매핑) + View(사용자화면) = 3티어 구조(MVC)
    하드웨어 단: DB서버1 + 웹서버1 = 서버 2티어 구조
                 서버1(웹서버+DB서버) = 1티어 구조
```
- 27. 프로그램 결과 출력: 이부분은 전자정부 프로젝트 -egov 프로젝트 AdminLTE        관리자관리부분 캡쳐

- 26. CMS가 왜 중용하냐하면? 그래서, 중요합니다.

```
    모든 웹프로그램은 CMS가 포함되어 있습니다.
    백엔드: 자바스프링 프로그램도 예외가 없습니다.
    프론트엔드: CMS많이 사용됩니다.
    CMS없는 웹프로그램은 없다고 보시면 됩니다.
```
- 25. 웹프로그램 도움말은 글로만 만드시는 게 아닙니다.
    위 화면처럼 이미지캡쳐 하시고, 간단한 코멘트 다는 것으로 매뉴얼이 만들어 집니다.

- 24. C언어로 만드는 구구단 프로그램 작성 후 실행
    
- 23. 라즈베리파이(*손바닥컴퓨터) 와 노드MCU(마이크로 컨트롤 유닛)라는 아두이노 개발보드

```
    원격으로 실습을 진행하는 방법을 고민 중입니다.
    9월17일(보름 후)날 필요하니까, 코로나19 때문에 원격으로 한다면, 고민중입니다.
```
- 22. C언어: gcc 컴파일러 사용(자바는 javac)

```
    gcc -o(옵션) hello(실행파일명) main.c(소스명) -l(링크옵션:외부라이브러리 가져오기)
    내장함수만으로 실행이 않될때, 외부 함수를 불러다 사용할때 -l (link)링크옵션입니다.
    앞으로 라즈베리파이 회로판에 발광다이오드(LED) 2개를 깜박이게 하는 소스(아래)
    gpio-led.c 파일
   ```
- 21. 개발에 사용되는 서버환경, 개발환경 및 실행 환경, 오픈SW명 작성

```
    전자정부표준프레임워크에서 참조: 
    CI:지속적인 소스 통합 / DI: 배포방식 통합 => 개발 파이프라인
    Jenkins 2.190.1: 예정 파스타 클라우드(젠킨스): 파이프라인 사용시 써보았습니다.
    서브버전 대신 => 깃허브 사용
```
- 20. 도움말 부분은 관리자관리 기능 사용법 기록(이미지 캡쳐로 도움말 대체)

- 19. 라이센즈 정책 적는 목적은 여러분이 오픈소스라이센스를 알고 있는지 확인용도

```
    GPL, Apache, LGPL, MIT 등 
    자바(OpenJDK 8), Mysql-커뮤니티버전(개인용무료), 스프링프레임워크(찾아서 기록)
    전자정부표준프레임워크(아파치 2.0 라이센스)
    필요한 이유: 취업한 회사에서 오픈소스를 사용하기 때문에...
```
- 18. 메인페이지 (AdminLTE 메인페이지 넣으시면 됩니다.)
  egov 프로젝트 캡쳐이미지

- 17.
 
```
내일 전자정부-egov 프로젝트 진행에 문제가 있으신분은 오늘 오후 7시 카톡주시면
    원격으로 봐드리겠습니다.(주말 여러학생분이 요청하셔서 바로 처리 되었습니다.)
    보통 20분내에 실행 가능하게 셋팅 됩니다.
```
- 16. 기존 javascript(네이티브 자바스크립트-오리지널 JS-구형 JS)

``` 
 -> JQuery사용
    기존: document.getElementById("요소이름-div").value;
    Jquery: $("요소이름-div").val();
```
- 15. 코딩시 학생분이 손들고 화면공유 요청 하시면, 제가 원격으로 접속하게 됩니다.

```
  원격작업화면은 여러분들에게 여기 화면에 같이 공유하도록 하겠습니다.
  에러 상황은 어떻게 처리하는지 모두 확인 가능 하시리라 생각 됩니다.
```
- 14. 타이틀은 전자정부 기존 심플홈템플릿을 리뉴얼 하기.

```
 전자정부 leejy-egov 프로젝트 작업하시던 내용을 시나리오에 적으시면 됩니다.
 기존 전장정부 심플 홈템플릿 문제점: 디자인이 html4, 사용자와 관리자가 한화면 포함.
 개선 사항 시나리오: html4->html5(AdminLTE사용), 관리자단 분리(/admin/home.do)
 위 제안요청서 ppt 문서에 기록하시면 됩니다.
 잘 구글 프레젠테이션 문서 잘 정리 하셔서, 면접보실때, 포트폴리오 제출시 같이 제출
 하시면, 좋은 점수를 받지 않을까 합니다.
```
- 13. CMS( 콘텐츠 관리 시스템 ): 간단하게는 게시판을 말합니다.

``` 
 제품: 웹하드(출력소에서 주사용-유료), 워드프레스(오픈소스-미국), 
 그누보드(오픈-국산)
 구글클라우드, 네이버클라우드.
```

### 20200820(목) 작업(아래)
- 3). 진도에 맞춰서 수업진행.
- 2). 전자정부프로젝트(스프링)를 리뉴얼(AdminLTE디자인관리자단)작업.
- 1). 9월중순 아두이노 작업시 스케치프로그램(언어) 사용 하기전, C언어 미리보기
  구름IDE(온라인)으로 실습.
### 20200819(수) 작업(아래)
- 4). 클라우드 파스타 앱 제거 후, 이클립스 PUSH(???-egovadmin관리용 php앱 이름)
- 3). 클라우드 파스타 mysql서비스 제거 후, 생성(???-egov-db 서비스 이름)
- 2). 타일즈 템플릿(UI쪽-레이아웃정리) 라이브러리 사용. 전자정부 프로젝트에 적용OK.
- 1). DB인터페이스 확인 (아래)
- 실행가능한 소스 https://github.com/miniplugin/Dbinterface_ora_ok.git
 ( 오라클 insert 후 커밋, System.out.print(vo.toString()); )
### 20200818(화) 작업(아래)
- 1). 관리자 등록시 아이디중복체크(RestAPI사용) 마무리.
- 주). RestAPI사용은 이클립스 내장브라우저에서는 않되기 때문에, 크롬 또는 IE사용OK.
### 20200817(월) 작업(아래)
- 3). 전자정부 프로젝트*(관리자관리기능추가한것) 파스타에 배포.(시간날때처리)
- 2). 관리자 등록시 아이디중복체크(RestAPI사용) 기능추가.
- 1). 관리자관리 기능 CRUD 마무리 OK.

### 20200814(금) 작업(아래)
- 3). 로컬PC에서 결과 확인 후 파스타에 배포예정.
- 2). 멤버 뷰페이지, 업데이트페이지, 인서트 페이지 생성.

```
우리가 기존에 작업한 스프링 프로젝트에서 아래처럼
<form id="폼이름" name="폼이름">
</form>
전자정부 프로젝트에서는 아래처럼
<form:form commandName="폼이름" name="폼이름">
</form:form>
```
- 1). 컨트롤러에 멤버리스트페이지 경로추가(아래)
- edu.human.com.member.web 패키지생성(컨트롤러용 패키지)
- MemberController.java @Controller클래스 생성.
- com/member/selectMember.do 경로추가(아래)
- 0). 관리자관리 경로 com/member/selectMember.do 로그인체크 추가
  로그인체크 관련 파일: egov-com-servlet.xml(서블렛파일) 인터셉터 관리
  뷰리졸버(viewresolver): 뷰단(jsp)단 해석기계.(웹페이지루트, 확장자 지정)

```
/**
 관리자관리 목록을 조회한다.
*/
@RequestMapping("/com/member/selectMember.do")
public List<EmployerInfoVO> selectMember(Model model) throws Exception {
	model.addAttribute("resultList", 멤버서비스호출);
	return "com/member/list";
}
```

### 20200812-13(수-목) 작업내역(아래)
- 6). jsp폴더(뷰폴더)에 inc/EgovIncLeftmenu.jsp 파일수정

```
메뉴 내용 추가(아래)
<li class="dept02"><a href="javascript:fn_main_headPageAction('57','com/member/selectMember.do')">관리자관리</a></li>
```
- 5). viewMember 쿼리+DAO+Service매서드 추가 후 Junit테스트OK.
- 4). Junit 테스트로 CRUD 확인.
- 3). Service 클래스에서 insertMember, updateMember, deleteMember 매서드 생성
- 2). DAO 클래스에서 insertMember, updateMember, deleteMember 매서드 생성
- 1). 쿼리 생성 : src/main/resources/egovframework/mapper/com/member/member_mysql.xml

### 20200811(화) 작업내역(아래)
- Junit 테스터로 DAO의 selectMember 실행 하기.

```
3. egov-com-servlet.xml 파일에서 component-scan 부분에서 제외된(exclude)를 -> 포함시킴(include)
2. src/test/java/~/TestMember.java 추가함. @ContextConfiguration 경로가 2개 추가.
1. 전자정부 프로젝트는 기본 Junit이 없기 때문에, 테스트환경 만들어야 함.. Pom.xml에 junit 모듈 추가하기.
```
- DAO(@Repository), Service(@Service) 만들기

```
3. service/impl/MemberServiceImpl.java (구현클래스) @Resource 대신 @Inject 사용
2. service/MemberService.java (인터페이스)
1. service/impl/MemberDAO.java (추상클래스를 사용, extends EgovAbstractMapper 필수 )
```
- 프로젝트에서 마이바티스 사용하기

```
4. 스프링-마이바티스 설정파일 추가: context-mapper.xml
- configLocation: 마아바티스 설정파일 위치 mapper-config.xml 추가
- mapperLocation: 쿼리가 존재하는 폴더위치 member_mysql.xml 추가(쿼리)
3. 관리자관리 테이블과 get,set 하는 VO 만들기: EmployerInfoVO.java
- 테이블 생성쿼리에서 필드명 복사 VO 자바파일에서 사용. 특이사항, 대->소문자 Ctrl+Shift+y 단축키
2. 관리자관리에 사용되는 테이블 확인 : emplyrinfo
1. 메이븐 모듈 추가(pom.xml)
<!-- 마이바티스 사용 모듈 추가 -->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis</artifactId>
	<version>3.2.8</version>
</dependency>
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis-spring</artifactId>
	<version>1.2.2</version>
</dependency>
```
  
### 20200810(월) 작업내역(아래)
- context-datasource.xml: Hsql 데이터베이스 사용 주석처리

```
<!-- hsql -->
<!-- 여기만 주석처리
<jdbc:embedded-database id="dataSource-hsql" type="HSQL">
	<jdbc:script location= "classpath:/db/shtdb.sql"/>
</jdbc:embedded-database>
-->
```
- globals.properties :(주,유니코드 에디터로 수정) DB에 관련된 전역변수 지정(아래)

```
# DB서버 타입(mysql,oracle,altibase,tibero) - datasource 및 sqlMap 파일 지정에 사용됨
Globals.DbType = mysql
Globals.UserName=root
Globals.Password=apmsetup
# mysql
Globals.DriverClassName=net.sf.log4jdbc.DriverSpy
Globals.Url=jdbc:mysql://127.0.0.1:3306/sht
#Hsql - local hssql 사용시에 적용
#Globals.DriverClassName=net.sf.log4jdbc.DriverSpy
#Globals.Url=jdbc:log4jdbc:hsqldb:hsql://127.0.0.1/sampledb
```
- web.xml : 톰캣(WAS)가 실행될때 불러들이는 xml설정들 확인.

```
egov-com-servlet.xml(아래) 
- DispatcherServlet(서블렛배치=콤포넌트-scan:@Controller,@Service,@Repository에 관련된 설정 수정)
- <context:component-scan base-package="egovframework,edu">
- 위에서 ,edu 추가: edu.human.com패키지추가로 해당패키지로 시작하는 콤포넌트를 빈(실행가능한 클래스)으로 자동등록하게 처리
```
- pom.xml : 메이븐 설정 파일중 Hsql DB를 Mysql DB사용으로 변경(아래)

```
<!-- 주석처리
<dependency>
	<groupId>org.hsqldb</groupId>
	<artifactId>hsqldb</artifactId>
	<version>2.3.2</version>
</dependency>
 -->
<!-- mysql driver 주석해제 -->	
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.31</version>
</dependency>

<!-- log4jdbc driver 주석해제. 기능:Console창에 쿼리보이기 -->        
<dependency>
    <groupId>com.googlecode.log4jdbc</groupId>
    <artifactId>log4jdbc</artifactId>
    <version>1.2</version>
    <exclusions>
        <exclusion>
            <artifactId>slf4j-api</artifactId>
            <groupId>org.slf4j</groupId>
        </exclusion>
    </exclusions>
</dependency>
```