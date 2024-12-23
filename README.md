# 스카이 플래너

스카이 플래너는 항공권 검색 및 예약을 위한 모바일 애플리케이션으로, 사용자가 손쉽게 항공권을 검색, 예약, 그리고 관리할 수 있도록 설계되었습니다. 사용자 친화적인 UI/UX와 효율적인 백엔드 아키텍처를 통해 편리한 경험을 제공합니다.

## 목차
- [애플리케이션 설명](#애플리케이션-설명)
- [주요 기능](#주요-기능)
- [액티비티 설명](#액티비티-설명)
- [API 사용](#api-사용)
- [구현 난제](#구현-난제)
- [애플리케이션 설계](#애플리케이션-설계)
- [서버 설계](#서버-설계)

## 애플리케이션 설명
### 애플리케이션 목적
스카이 플래너는 사용자에게 항공권 검색, 예약, 그리고 예약 관리 기능을 제공하는 모바일 애플리케이션입니다. 

### 사용 시나리오
1. **회원가입 및 로그인**
   - 일반 로그인 및 Facebook 로그인 제공.
2. **항공권 검색**
   - 출발지, 도착지, 출발일, 귀국일(왕복) 입력 후 조건에 맞는 항공권 검색.
   - 다양한 필터(최저가, 최단 여행 시간 등)를 통해 결과 정렬.
3. **항공권 예약**
   - 상세 정보 확인 후 핀 번호 인증을 통해 예약 완료.
   - 예약 금액의 1%를 마일리지로 적립.
4. **마이페이지 관리**
   - 예약 내역 확인 및 취소.
   - 누적 마일리지 정보 제공.

## 주요 기능
- **항공권 검색 및 필터링**: 조건에 맞는 항공권을 검색하고 정렬.
- **핀 번호 인증 기반 예약**: 보안성 강화.
- **마이페이지**: 마일리지 확인 및 예약 내역 관리.
- **Facebook 간편 로그인**: 사용자 경험 개선.

## 액티비티 설명

### 1. `LoginActivity`
- **역할**: 회원 로그인 및 Facebook 로그인 처리.
- **UI/UX**: 아이디와 비밀번호 입력 필드, Facebook 로그인 버튼 제공.

### 2. `SignUpActivity`
- **역할**: 새로운 회원 가입 처리.
- **UI/UX**: 필드 실시간 검증 및 회원가입 성공 시 로그인 화면으로 이동.

### 3. `MainActivity`
- **역할**: 항공권 검색 및 마이페이지 이동.
- **UI/UX**: 출발지, 도착지, 날짜 선택 필드와 검색 버튼 제공.

### 4. `FlightActivity`
- **역할**: 조건에 맞는 항공권 리스트 표시 및 필터링.
- **UI/UX**: 간단한 필터 옵션과 리스트뷰 제공.

### 5. `DetailActivity`
- **역할**: 선택된 항공권의 상세 정보 표시 및 예약 처리.
- **UI/UX**: 상세 정보 뷰 및 예약 버튼 제공.

### 6. `MyPageActivity`
- **역할**: 마일리지와 예약 내역 조회.
- **UI/UX**: 간결한 마일리지 정보와 예약 리스트 제공.

### 7. `ReservationDetailActivity`
- **역할**: 예약 상세 정보 표시 및 예약 취소 처리.
- **UI/UX**: 예약 취소 버튼 제공 및 사용자 확인 단계 추가.

## API 사용
### 주요 API와 역할
1. **로그인 API**: 사용자 인증.
2. **회원가입 API**: 새로운 사용자 추가.
3. **항공권 조회 API**: 조건에 맞는 항공권 검색.
4. **예약 API**: 예약 추가 및 마일리지 적립.
5. **예약 취소 API**: 예약 삭제 및 마일리지 차감.

## 구현 난제
1. **항공권 데이터 생성**
   - 6000개 이상의 항공권 데이터를 생성하며 현실성을 유지.
2. **왕복 항공권 조합**
   - 편도 데이터를 조합하여 왕복 데이터를 생성.
3. **FlightActivity 데이터 처리**
   - 편도와 왕복 JSON 포맷 차이를 처리하며 사용자에게 최적의 경험 제공.

## 애플리케이션 설계

### 흐름도
- **로그인**: `LoginActivity` → `MainActivity`
- **회원가입**: `LoginActivity` → `SignUpActivity`
- **항공권 예약**: `MainActivity` → `FlightActivity` → `DetailActivity` → `MyPageActivity`
- **예약 취소**: `MyPageActivity` → `ReservationDetailActivity` → `MyPageActivity`

## 서버 설계

### 아키텍처
- **API Gateway** → **AWS Lambda** → **RDS (MySQL)**
- 서버리스 아키텍처로 확장성과 비용 효율성 극대화.

### 주요 Lambda 함수
1. **skyPlannerFlight**: 항공권 검색.
2. **skyPlannerReservation**: 예약 추가 및 마일리지 업데이트.
3. **skyPlannerCancelReservation**: 예약 취소 및 마일리지 차감.
4. **skyPlannerInfo**: 마이페이지 정보 제공. User 테이블에서 사용자의 현재 마일리지 조회.
5. **skyPlannerUser**: 사용자 회원가입, 로그인 등 사용자 관리 작업 수행. User 테이블과 상호작용하여 회원 정보 추가, 수정, 조회. 


### 데이터 흐름
- 클라이언트 → API Gateway → Lambda → RDS → Lambda 응답 → 클라이언트.

### 워크플로우
![image](https://github.com/user-attachments/assets/020b3f7c-22de-452d-a84d-ebb5af62c324)
![image](https://github.com/user-attachments/assets/3d26ffa1-24b3-4637-821b-56ad49837393)
![image](https://github.com/user-attachments/assets/0ef0b8b5-31ff-49a2-9a87-11d80e131285)
![image](https://github.com/user-attachments/assets/a5f727ad-07ef-4a77-ab11-ef1b6bdf043a)
![image](https://github.com/user-attachments/assets/3525d056-9490-4fe4-9c1d-0cc5fc98a4a5)
![image](https://github.com/user-attachments/assets/5df8d09c-94a7-4588-93f6-34e0ea787d0a)
![image](https://github.com/user-attachments/assets/8d9fde26-fcb1-410e-ae09-0d8290b46e27)

![image](https://github.com/user-attachments/assets/2717a387-c35b-4218-ac85-67c538dc09fd)
![image](https://github.com/user-attachments/assets/d99dfae9-f4bb-433c-8eac-c6130db28e23)
![image](https://github.com/user-attachments/assets/d7de0dc3-e1b5-4149-ae26-c35c115a78cd)
![image](https://github.com/user-attachments/assets/7aae534a-e2ec-4f43-bc86-6675e52b1017)
![image](https://github.com/user-attachments/assets/1585e7c3-347f-4b2c-aca4-b9cdc4494036)









