| 🔢 Calculator Project 🔣 |  
|:------------------------:|
|<img src="https://github.com/user-attachments/assets/f24f2217-714a-47e4-ad91-12d2f883802c" alt="image" width="300">|


---

## 🎫 구현된 프로젝트
<img src="https://github.com/user-attachments/assets/4031e8dc-43fb-448e-bd55-2bdb86960eb6" width="400">

---

## ⚒ 개발자 소개

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
- 계산된 값들은 우측에 별도로 저장되며, Max Del 버튼을 통해 저장된 값 중 가장 큰 값을 삭제할 수 있습니다.  

---

## 🌟 주요 기능

#### 1. 사칙연산: 더하기, 빼기, 곱셈, 나눗셈
#### 2. 입력 관리: C(전체 초기화), CE(최근 입력 삭제), 백스페이스
#### 3. 저장된 값 관리: 계산된 값들을 오른쪽에서 확인하고, 저장된 값 중 가장 큰 값을 삭제할 수 있는 기능을 제공

---

## 📑 요구사항

1. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 하기 (캡슐화)
- 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
- 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)

2. 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현

3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기
- Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용

4. double 타입의 값을 전달 받아도 연산이 수행하도록 만들기
- 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장 (제네릭)

5. 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
- 해당 메서드를 구현할 때 Lambda & Stream을 활용하여 구현

---

## 🔑 구현된 기능

### buttonListner

1. ButtonFunctionListener

✔ 지우기 버튼 `◀`구현: 입력된 값을 하나씩 삭제
  - 입력값이 없을 경우 Swing Dialog 출력
    
✔ 초기화 버튼 `C` 구현: 입력된 값과 현재 계산 과정을 삭제
  - 입력값이 없을 경우 Swing Dialog 출력  
  - 저장값이 없을 경우 Swing Dialog 출력
  - 값을 초기화 후 라벨들 재설정
    
✔ 삭제 버튼 `CE` 구현: 현재 입력된 값 삭제
  -  값을 초기화 후 라벨들 재설정

✔ 큰 값 출력 버튼 `Big` 구현: 현재 입력된 값보다 큰 저장값들 호출
  - 입력값이 없을 경우 Swing Dialog 출력
  - 저장값이 없을 경우 Swing Dialog 출력
    
✔ 저장 값 삭제 버튼 `Del` 구현: 오른쪽에 저장된 값들을 먼저 저장된 순서대로 삭제
  -  저장값이 없을 경우 Swing Dialog 출력
  -  저장값 삭제 되었을 때 Swing Dialog 출력 후 저장값 재출력

2. InputBtnClickListener

✔ 숫자 버튼 구현: `actionPerformed` 메서드를 통해 숫자 버튼 구현
  -  버튼 클릭 시, Label 값 변경 및 InputValue 값 변환

3. SymbolBtnClickListener

✔ 등호 버튼 구현 : `=` 버튼 구현

✔ 연산 버튼 구현 : `+`, `-`, `/`, `*` 버튼 구현

### logic

1. Calculators

✔ `ArithmeticCalculator()` : `=` 버튼 구현

2. CalculatorState

✔ 등호 버튼 구현 : `=` 버튼 구현

### swingui

1. Calculators

2. CalculatorState

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

