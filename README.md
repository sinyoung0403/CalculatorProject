| 🔢 Calculator Project 🔣 |  
|:------------------------:|
|<img src="https://github.com/user-attachments/assets/f24f2217-714a-47e4-ad91-12d2f883802c" alt="image" width="300">|


---

## 🎫 구현된 프로젝트
<img src="https://github.com/user-attachments/assets/4031e8dc-43fb-448e-bd55-2bdb86960eb6" width="600">

---

## 🧑‍💻 개발자 소개

|  |                                   팀원                                   |
|:-------------:|:----------------------------------------------------------------------:|
|프로필| ![image](https://avatars.githubusercontent.com/u/94594402?v=4&size=64) |
|이름|                                  박신영                                   |
|GitHub|                              sinyoung0403                              |
|기술블로그|                 [블로그](https://sintory-04.tistory.com/)                 |

---

## ⚒ 프로젝트

### 1. 프로젝트 이름

- **" Calculator Project "**

### 2. 프로젝트 소개

- 이 계산기는 사용자가 직관적으로 계산을 수행할 수 있도록 Swing UI로 만든 Java Project 입니다. 
- 기본적인 사칙연산(더하기, 빼기, 곱셈, 나눗셈)을 지원하며, 사용자는 입력한 숫자와 계산 결과를 쉽게 확인할 수 있습니다.
- 추가적으로 'C'와 'CE' 버튼을 통해 입력값을 초기화하거나 최근 입력을 지울 수 있으며, 백스페이스 기능을 제공하여 실수로 입력한 숫자를 쉽게 수정할 수 있습니다.
- 계산된 값들은 우측에 별도로 저장되며, 버튼을 통해 저장된 값 삭제 및 입력 값보다 큰 값을 출력할 수 있습니다. 

### 3. 프로젝트 실행

#### 1) `basic` 패키지

- basic 패키지는 기본 계산기입니다. 해당 파일은 Lv3 까지 구현되어 있습니다.
- src/com/example/basic/App.java 를 실행 시키면 계산기를 실행할 수 있습니다.

#### 2) `siwng` 패키지

- swing 패키지는 swing UI를 가진 계산기입니다. 해당 파일은 Lv3 까지 구현되어 있습니다.
- src/com/example/swing/App.java 를 실행 시키면 계산기를 실행할 수 있습니다.

---

## 🌟 주요 기능

#### 1. 사칙연산: 더하기, 빼기, 곱셈, 나눗셈
#### 2. 입력 관리: C(전체 초기화), CE(최근 입력 삭제), 백스페이스
#### 3. 저장된 값 관리: 계산된 값들을 오른쪽에서 확인하고, 저장된 값 중 가장 큰 값을 삭제할 수 있는 기능을 제공

---

## 📑 요구사항

1 App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 하기 (캡슐화)
- 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
- 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)

➡ 저장 값들을 `private` 로 선언하여 관리했으며, 이를 Getter 와 Setter만 접근하게 구현했습니다.
- `private static List<Object> calculatorList = new ArrayList<>();`
- 다른 `Listner` 클래스에서 공유가 되어야하는 값이기 때문에 `static` 으로 설정.

2 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현

➡ `del` 버튼을 누를 시 가장 먼저 저장된 연산결과를 삭제하도록 구현했습니다.

3 Enum, 제네릭, 람다 & 스트림을 이해한 계산기
- Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용

➡ Enum 을 활용하여 연산자 타입에 따른 사칙연산을 구현했습니다.
  - `public enum OperatorType{}`

4 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기
- 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장 (제네릭)

➡ 필드에서 num 값을 `T`로 선언했습니다.

5 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
- 해당 메서드를 구현할 때 Lambda & Stream을 활용하여 구현
 
➡ 저장값을 재 출력할 때 람다를 사용했습니다.
  - `String textList = (String) cs.getSaveList().stream().reduce("",(s1,s2) -> s1+"<br>"+s2+"<br>");`

---

## 📂 buttonListener

✔ `ButtonFunctionListener`

1. ◀ (Back):

  - 입력값이 비어있지 않으면 마지막 입력값을 제거하고, presentLabel에 업데이트
  - CalculatorList가 비어있을 경우, removeInputNumber()로 입력값만 제거

2. C (Clear):

  - 모든 값 초기화 (clearInputNumber(), clearCalculatorList(), clearStepText())
  - 초기화 후 stateLabel, presentLabel에 업데이트된 상태 반영

3. CE (Clear Entry):
 
  - 현재 입력값만 초기화하고, presentLabel에 반영

4. Big:
  - 입력값보다 큰 값들을 출력하는 기능
  - saveResultList에서 현재 입력값보다 큰 값들을 필터링하여 보여줌
  - 값이 없거나 saveResultList가 비어있을 경우 에러 메시지 출력

5. Del (Delete):

  - saveResultList에서 첫 번째 값을 삭제하고, 해당 결과를 myList에 재출력
  - 삭제된 값에 대한 알림 메시지 출력

6. Negative:

  - 입력값이 음수가 아닌 경우 음수로 변경하여 presentLabel에 반영
  - 이미 음수인 값에는 에러 메시지 출력

✔ `InputBtnClickListener`

1. 숫자 버튼 (1~9, 0):

- 버튼 클릭 시 해당 숫자를 입력값에 추가하고, label에 반영

2. 소수점 (.):

- 이미 소수점이 포함되어 있으면 에러 메시지를 출력
- 소수점이 없다면 입력값에 소수점을 추가하고, label에 반영

✔ `SymbolBtnClickListener`

1. 등호 버튼 (=):

- 현재 입력된 값이 비어 있으면 오류 메시지를 출력
- 입력값이 있으면 계산을 수행하고, 결과를 화면에 표시
- 연산 기록을 저장하고 계산 결과를 초기화

2. 사칙연산 버튼 (➕, ➖, *, ➗):

- 입력값이 없으면 오류 메시지 출력
- 입력값이 있으면 사칙연산을 수행하고, 해당 연산기호를 연산 리스트에 추가
- 계산 후 결과를 화면에 표시하고 연산 기록을 저장


## 📂 logic

✔ `Calculators`

1. 연산 기능 (ArithmeticCalculator)

- SUM(+): 더하기 연산 수행
- SUBTRACT(-): 빼기 연산 수행
- MULTIPLY(*): 곱하기 연산 수행
- DIVIDE(/): 나누기 연산 수행 (0으로 나누면 ArithmeticException 발생 및 Swing Dialog 출력)

2. 타입 변환 (toBigDecimal, toType)

- toBigDecimal(T number): T 타입 숫자를 BigDecimal로 변환
- toType(BigDecimal result): BigDecimal 값을 T 타입으로 변환

3. 숫자 설정 (setNum)

- 두 개의 숫자(num1, num2)를 설정하여 연산 준비

✔ `CalculatorState`

1. 데이터 관리

- calculatorList : 연산 대상 저장
- stepString : 연산 과정 표시
- inputString : 사용자 입력 값 저장
- saveList : 전체 결과 저장
- saveResultList : 연산 결과만 저장

2. 값 설정 및 추가

- add/setInputNumber(String number) : 입력값 추가/설정
- addSaveList(String text) : 결과 저장
- addSaveResultList(Double number) : 연산 결과 저장
- addCalculatorList(S number) : 연산 대상 추가

3. 값 조회

- getInputString() / getStepText() : 입력값 & 연산 과정 조회
- getCalculatorList() / getSaveList() / getSaveResultList() : 저장된 데이터 조회
- getCalculatorListSize() : 연산 대상 개수 반환


4. 값 삭제 및 초기화

- clearInputNumber() / clearStepText() / clearCalculatorList() : 입력 & 과정 초기화
- removeInputNumber() : 입력값 마지막 문자 삭제
- removeSaveList(int index) / removeSaveResultList(int index) : 특정 저장값 삭제

5. 라벨 수정

- insertLabel(JLabel label, String text) : UI 라벨 업데이트

--------------------

## 📂 swingui

✔ `swingUI`

1. UI 구성 요소
- 프레임: 계산기 창 생성 및 설정
- 패널: 버튼 및 레이블을 포함하는 컨테이너
- 라벨: stateLabel (계산 과정), presentLabel (입력값), myList (저장된 값) 표시
- 버튼:
  - 연산 버튼: sumBtn, subtractBtn, multiplyBtn, divideBtn, equalBtn
  - 숫자 버튼: btn0 ~ btn9, pointBtn
  - 기타 버튼: ceBtn, cBtn, backBtn, negativeBtn, delBtn, viewBtn

2. 버튼 클릭 리스너

  -숫자 및 점 버튼: InputBtnClickListener → 입력값 처리
  -연산 버튼: SymbolBtnClickListener → 연산 수행 및 계산 처리
  -기타 버튼: ButtonFunctionListener → 지우기, 뒤로가기 등 기능 처리

3. 레이아웃 설정

- 프레임 크기: 460x540
- 버튼 배치: setBounds()로 버튼 위치 및 크기 설정
- 프레임 표시: frame.setVisible(true)로 화면에 출력

✔ `SwingOutput`

1. Error Dialog 출력

2. 안내문 출력

---

## ️️🪢 데이터 흐름 (Data Flow)

1. 사용자 입력 (Swing UI)

✔ 사용자가 **Swing UI**에서 버튼을 클릭하여 연산을 수행합니다.
  - 숫자, 연산자, 기타 버튼 클릭

2. 버튼 클릭 리스너 (Button Click Listeners)

✔ 버튼 클릭에 따라 각기 다른 리스너가 호출됩니다:
  - `InputBtnClickListener`: 숫자 클릭 시 처리
  - `SymbolBtnClickListener`: 사칙연산 연산자 처리 (예: +, -, *, /)
  - `ButtonFunctionListener`: 삭제 및 백스페이스 처리 (연산 결과 삭제)

3. 연산 요청 처리 (Calculation Request)

✔ **Calculator 클래스**에서 연산을 수행합니다.
  - Enum 타입(`Operator`)을 사용하여 연산자 처리
  - 제네릭을 사용하여 다양한 타입의 값을 연산
  - `ArithmeticCalculator`에서 계산을 처리하고 결과를 컬렉션에 저장

4. 계산 결과 저장 (Calculation Results Storage)

✔ **CalculatorsState** 클래스의 컬렉션 필드에 연산 결과를 저장합니다.
  - 캡슐화 되어 있어, 직접 접근할 수 없고 **getter**와 **setter** 메서드를 통해 간접 접근

5. 결과 출력 (Output)

✔ 계산된 결과는 **Swing UI**의 라벨을 통해 화면에 표시됩니다.
  - **CalculatorState**의 `insertLabel` 메서드를 통해 **Swing UI** 의 라벨 조작

6. 연산 결과 삭제 (Delete Calculation)

✔ ButtonFunctionListener 클래스의 `actionPerformed` 메서드가 가장 먼저 저장된 연산 결과를 **CalculatorsState** 클래스에서 삭제
  - 삭제 기능은 `removeSaveList()`와 `removeResultSaveList()` 메서드를 통해 처리

7. 값 비교 및 출력 (Compare and Print Results)

✔ 사용자가 **Swing UI**를 통해 입력한 값보다 큰 계산 결과들을 출력
  - ButtonFunctionListener 클래스의 `actionPerformed` 메서드에서 사용하여 **Lambda**와 **Stream**을 활용하여 필터링하고 출력
  - 이 기능은 저장된 연산 결과 리스트에서 입력 받은 값보다 큰 결과값 들만 출력한다.


### 📃 흐름 요약

1. 사용자 입력 → **Swing UI**
2. 버튼 클릭 → **InputBtnClickListener**, **SymbolBtnClickListener**, **ButtonFunctionListener**
3. 연산 요청 → **Calculator** 클래스 (Enum, 제네릭 사용)
4. 연산 결과 저장 → **CalculatorsState** (캡슐화된 컬렉션 필드)
5. 결과 출력 → **Swing UI** (CalculatorState 통해 업데이트)
6. 결과 삭제 → **ButtonFunctionListener** 클래스
7. 값 비교 → **Lambda & Stream**을 활용하여 **Swing UI**로 입력된 값보다 큰 결과값 출력

---

## 📚 Stacks

### ✔️ Environment
<img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">


### ✔️ Project
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"> 

<br>
<br>
