import java.util.*;

public class ch11 {
}

class Exercise11_1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList kyo = new ArrayList(); // 교집합
        ArrayList cha = new ArrayList(); // 차집합
        ArrayList hap = new ArrayList(); // 합집합
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);


        //list1이 하나씩 읽을 수 있게 iterator를 쓴다.
        Iterator it = list1.iterator();


        //교집합 kyo
        //it이 하나씩 나오면서 읽다가 더이상 요소가 없다면(false) 그만
        // 1/14 문제점1 : it.next()로 확인했는데 그 요소를 다시 넣으려고하니 이미 출력하고 사라져서 그 idnex 값을 제외하고 다음 값이 출력됨.
        while(it.hasNext()) {
            //next로 뽑은 요소를 변수로 지정해서 그걸 안에 넣어버리자.
            Object i = it.next();

            //it인 list1가 하나씩 가면서 list2랑 같은지 확인
            if (list2.contains(i)) {
                // 같다면 kyo에 add로 포함
                kyo.add(i);
            }
        }
        //차집합은 it인 list1에는 포함하지만 list2에는 포함하지 않아야한다. 그럼 기존에 cha = list1이여야한다.
        //즉, contains에 포함이 되면 안된다.
        //equals의 ! 이니깐 그냥 else로 여집합 해도 될 듯?
        cha.addAll(list1);
        cha.removeAll(kyo);

        //합집합 현재 문제 : 공통부분을 빼고싶음.
        //가장 단순한게 생각하면, list1을 쭉 쓰고, list2에서 list1이 가지지 못한 부분만 넣어주면 된다.
        // 생각해보니 차집합이 지금 list1에서 list2랑 겹치지않은 부분만 있으니, 둘이 합치면 될 것 같다.
        hap.addAll(cha);
        hap.addAll(list2);
        // 어떻게든 나왔긴했지만 가장 큰 문제점,
        // 1. 정렬을 못했다.
        // 2. hasnext로 배열에 값이 남아있는것을 확인하고 next로 순서대로 뽑아내서 하나씩 대조는 하는데, 그걸 일치하면
        // 정해진 집합으로 넣어야하는데, next()로하니깐 if문으로 확인한 값이 아니라 그 다음 조건에 맞는 값이 들어간다.

        System.out.println("list1="+list1);
        System.out.println("list2="+list2);
        System.out.println("kyo="+kyo);
        System.out.println("cha="+cha);
        System.out.println("hap="+hap);
    }
}

class Exercise11_2 {
    //호출 스택에 main 생성
    public static void main(String[] args) {
        //list 순서ㅇ, 중복ㅇ ex)대기자 명단
        //set 순서x, 중복x ex) 양의 정수 집단, 4발 달린 동        //map 순서x, 중복(key 중복x, value 중복ㅇ) ex) id와 pw

        //새로운 ArrayList list 생성
        ArrayList list = new ArrayList();
        // list에 배열처럼 되어서 3,6,2,2,2,7 입력됨 (중복 허용, 순서 있음)
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(7);

        // set은 중복을 허용하지 않는다. list의 내용을 받으면서 중복 제거됨
        // 3,6,2,7
        HashSet set = new HashSet(list);

        // 위와 동일
        // 3,6,2,7
        TreeSet tset = new TreeSet(set);

        // 스택 생성 스택은 위에서부터 차곡차곡 쌓여서 다시 햄 위에서부터 차곡차곡 없어짐
        Stack stack = new Stack();

        // 그러니 하나씩 들어오면 맨 처음께 가장 밑이 된다.
        // 7
        // 2
        // 6
        // 3 여기가 가장 밑바닥
        stack.addAll(tset);

        //stack이 빌때까지 출력해라(가장 위에서부터 하나씩 휴지뽑아 쓰듯이 쓴다)
        while(!stack.empty())
            System.out.println(stack.pop());

        // 따라서 예상답안은
        // 7
        // 2
        // 6
        // 3
    }
}

//    다음 중 ArrayList에서 제일 비용이 많이 드는 작업은?
//    단 작업도중에 ArrayList의 크기 변경이 발생하지 않는다고 가정한다
//        a. 첫 번째 요소 삭제
//        b. 마지막 요소 삭제
//        c. 마지막에 새로운 요소 추가
//        d. 중간에 새로운 요소 추가
// 답은 a
// 풀이과정 :
//a순서 : list.remove(0) (첫번째 index 값 삭제),
//        list.addAll(list, 1, list.length) (list의 2번째 값부터 마지막까지 싹 다 가져와서 앞으로 끌어옴),
//        list.remove(list.length) (list의 맨 마지막 값은 기존의 값이 그대로 남아있으니 제거),
//        size--; (빈 공백 칸이 하나 남으니 size를 줄인다.)
//
//b순서 : a순서 3번 4번 실행
//
//c순서 : size++; (빈 방이 없으니 하나 생성)
//        list.add(값) (빈 방에 채우기)
//
//d순서 : a와 동일하나 처음에 list.remove(값) 여기가 0은 아니라서, 2단계에서 전부 끌어올 필요가 없다.
//        (그러나 a 제외하면 다음으로 비용이 많이 드는 작업이다.)


//[11-4] LinkedList (doubly 클래스는 이름과 달리 실제로는 이중 원형 연결리스트
//        circular linked list) . LinkedList 11 로 구현되어 있다 인스턴스를 생성하고 개의 요소를
//        추가했을 때 이 개의 요소 중 접근시간 이 가장 오래 걸리는 요소는 몇 , 11 (access time)
//        번째 요소인가?
//
//정답 : 모두 같다.
//풀이과정 :정확하게 이중 원형 연결리스트가 뭔지는 모르겠지만 일단 LinkedList는 기차처럼 연결되어있다.
//        여기에 만약 중간에 요소를 넣는다면 기차 연결 끊듯이 중간을 끊고 요소를 넣어주고, 앞 뒷 칸의 연결된 주소만 바꿔주면 된다.
//        그럼 이게 변형해서 2중 원형 연결리스트니깐 서로 앞뒤로 연결되어있고, 원형이니 굴렁쇠처럼 맨 처음 요소는 맨 뒤의 요소와 연결되어있을거다.
//        그러니 어딜 끊고 새로운 요소를 넣어도 똑같을거다.

// student3이 comparable과 포함관계가 되도록 설정(이미 comparable은 구현이 되어있어서 내가 건들필요가 없단다!)
class Student3 implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;
    Student3(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int compareTo(Object obj) {
        // obj object가 형변환이 가능한지부터 확인
        if(obj instanceof Student3) {
            Student3 st = (Student3) obj;
            //obj의 name이 아니라 새로 만든 st가 obj가 되어서 st.name으로 해야한다.
            return name.compareTo(st.name);
        }
        //이거 어떡하지?
        else{
            return -9999999;
        }
    }

    int getTotal() {
        return kor+eng+math;
    }
    float getAverage() {
        return (int)((getTotal()/ 3f)*10+0.5)/10f;
    }
    public String toString() {
        return name +","+ban +","+no +","+kor +","+eng +","+math
                +","+getTotal() +","+getAverage();
    }
}
class Exercise11_5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student3("홍길동 ",1,1,100,100,100));
        list.add(new Student3("남궁성 ",1,2,90,70,80));
        list.add(new Student3("김자바 ",1,3,80,80,90));
        list.add(new Student3("이자바 ",1,4,70,90,70));
        list.add(new Student3("안자바 ",1,5,60,100,80));

        Collections.sort(list);
        Iterator it = list.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}


class Student333 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    Student333(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    int getTotal() {
        return kor+eng+math;
    }
    float getAverage() {
        return (int)((getTotal()/ 3f)*10+0.5)/10f;
    }
    public String toString() {
        return name
                +","+ban
                +","+no
                +","+kor
                +","+eng
                +","+math
                +","+getTotal()
                +","+getAverage()
                ;
    }
    public int compareTo(Object o) {
        if(o instanceof Student333) {
            Student333 tmp = (Student333)o;
            return name.compareTo(tmp.name);
        } else {
            return -1;
        }
    }
} // class Student
class Exercise11_6 {
    //이 부분은 평균과 비교한 값을 가지고, 안에 들어갈 수 있는지를 확인
    // set에 있는 학생들 데이터가 from~to 사이에 들어가는 애들이 몇 명인가?
    static int getGroupCount(TreeSet tset, int from, int to) {
        Student333 st333 = new Student333("",0,0,from,from,from);
        Student333 st3332 = new Student333("",0,0,to,to,to);

        return tset.subSet(st333,st3332).size();
    }

    public static void main(String[] args) {
        TreeSet set = new TreeSet(new Comparator() {
            public int compare(Object o1, Object o2) {
                // 두 학생의 평균을 비교 후 정렬해야한다.
                // 둘 다 형변환 가능한지 확인
                if(o1 instanceof Student333 && o2 instanceof Student333){
                    Student333 st333 = (Student333) o1;
                    Student333 st3332 = (Student333) o2;
                    //평균값 구했는데 메서드 있다는걸 다 만들고나서 알았다^-^
                    return (int) (st333.getAverage()-st3332.getAverage());
                }
                //반대는 오류니깐 쉽게 해결
                else{
                    return -999;
                }
            }
        });
        set.add(new Student333("홍길동 ",1,1,100,100,100));
        set.add(new Student333("남궁성 ",1,2,90,70,80));
        set.add(new Student333("김자바 ",1,3,80,80,90));
        set.add(new Student333("이자바 ",1,4,70,90,70));
        set.add(new Student333("안자바 ",1,5,60,100,80));
        Iterator it = set.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        System.out.println("[60~69] :"+getGroupCount(set,60,70));
        System.out.println("[70~79] :"+getGroupCount(set,70,80));
        System.out.println("[80~89] :"+getGroupCount(set,80,90));
        System.out.println("[90~100] :"+getGroupCount(set,90,101));
    }
}


class Student117 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    Student117(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    int getTotal() {
        return kor+eng+math;
    }
    float getAverage() {
        return (int)((getTotal()/ 3f)*10+0.5)/10f;
    }
    public String toString() {
        return name
                +","+ban
                +","+no
                +","+kor
                +","+eng
                +","+math
                +","+getTotal()
                +","+getAverage()
                ;
    }
} // class Student117
class BanNoAscending implements Comparator {
    public int compare(Object o1, Object o2) {
        // o1이랑 o2가 일단 형변환이 가능한지 확인
        if(o1 instanceof Student117 && o2 instanceof Student117){
            Student117 st117 = (Student117) o1;
            Student117 st1172 = (Student117) o2;

            //반을 비교한다. 만약 compareTo했는데 0이 나온다면?
            // 이상하게 ban을하고, no를 2중 조건으로 설정이 안된다.
            // 사용한 방법
            // ban==ban && no==no
            // compare && compare
            if(st117.ban==st1172.ban){
                //왜 값이 뭘 넣어도 바뀌지 않을까 (2021.1.14생각)
                // (2021.1.15 생각) 오버로딩 || 오버라이딩을 해보자고 생각함.
                // 오버라이딩을 하다가 그냥 여기에서 나온 st117.no와 st1172.no의 int 값 자체를 오버로딩으로 보내버려서
                // 1 또는 -1로 값을 받는게 빠르지않을까 생각함.
                return compare(st117.no, st1172.no);
            }
            //만약 다르다면 그냥 반을 비교하자
            else{
                return compare(st117.ban, st1172.ban);
            }
        }
        //형변환이 안되면 오류
        else{
            return -1;
        }
    }
    // compare 오버로딩(이걸 위한 대상은 윗 compare메서드에서 st117.no와 st1172.no다)
    public int compare(int o1, int o2){
        // compare 비교하듯이 그냥 단순 int 값이니 대소 비교만 해주면 될 것 같다.
        // 3항 연산자를 이요하면 더 빠른 값을 낼 수 있을것 같다.
        if(o1>o2){
            return 1;
        }
        else{
            return -1;
        }
    }
}
class Exercise11_7 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student117("이자바 ",2,1,70,90,70));
        list.add(new Student117("안자바 ",2,2,60,100,80));
        list.add(new Student117("홍길동 ",1,3,100,100,100));
        list.add(new Student117("남궁성 ",1,1,90,70,80));
        list.add(new Student117("김자바 ",1,2,80,80,90));
        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}




class Student118 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    int total; // 총점
    int schoolRank; // 전교등수
    Student118(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        total = kor+eng+math;
    }
    int getTotal() {
        return total;
    }
    float getAverage() {
        return (int)((getTotal()/ 3f)*10+0.5)/10f;
    }
    public int compareTo(Object o) {
        // 그 어디에서도 compareTo를 사용하고있지않다.
        // 그 뜻은 내가 아래 코드에서 사용해야한다는 뜻.

        // 여기에서 내가 실수를했다!!!! 왜 정렬이 안되지ㅠㅠㅠ이러면서 고생했는데 Comparable로 하니깐 되었다.
        // 사전에 형변환 검사도 당연히 하고, int로 위에 this값과 여기서 주어지는 매개변수의 필요한 요소만 뽑아서 비교하자.
        if(o instanceof Student118){
            int thisVal = this.total;
            int anotherVal = ((Student118) o).total;
            //삼항연산자를 쓰면 아주 조금이라도 빨라진다. 이참에 바꿔보자
//            if(thisVal>anotherVal){
//                return -1;
//            }
//            else{
//                return 1;
//            }
            return thisVal>anotherVal ? -1 : 1;
        }
        else{
            return -1;
        }
    }
    public String toString() {
        return name
                +","+ban
                +","+no
                +","+kor
                +","+eng
                +","+math
                +","+getTotal()
                +","+getAverage()
                +","+schoolRank // 새로추가
                ;
    }
} // class Student118
class Exercise11_8 {
    public static void calculateSchoolRank(List list) {
        Collections.sort(list); // list . 먼저 를 총점기준 내림차순으로 정렬한다
        int prevRank = -1; // 이전 전교등수
        int prevTotal = -1; // 이전 총점
        int length = list.size();
        //만약 동점이 나올 경우 list로 나오는 객체 수가 하나씩 나올때마다 증가하는 count로 등수를 바꿔주면 된다.
        int count = 1;

        // 1.   . 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다
        for(int i=0; i<length; i++){
            Student118 st118 = (Student118) list.get(i);

            // 1.1 (total) (prevTotal) 총점 이 이전총점 과 같으면
            //이전 등수 를 등수 로 한다 (prevRank) (schoolRank) .
            if(st118.total==prevTotal){
                st118.schoolRank = prevRank;
            }
            //1.2 , 총점이 서로 다르면
            //등수 의 값을 알맞게 계산해서 저장한다 (schoolRank) .
            //이전에 동점자 였다면 그 다음 등수는 동점자의 수를 고려해야 한다 , .
            //( ) 실행결과 참고
            else{
                //동점자는 어떻게 해야할지 몰라서 count로 바꿔줬다. 어짜피 사람 수만큼의 1등부터 꼴등까지 있어야한다.
                //그걸 동점자가 하나 가져가더라도 숫자가 그대로 증가하는 int 값이 하나 있으면 될거라고 생각했다.
                st118.schoolRank = count;

                prevTotal = st118.total;
                prevRank = st118.schoolRank;
            }
            count++;
        }

    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student118("이자바 ",2,1,70,90,70));
        list.add(new Student118("안자바 ",2,2,60,100,80));
        list.add(new Student118("홍길동 ",1,3,100,100,100));
        list.add(new Student118("남궁성 ",1,1,90,70,80));
        list.add(new Student118("김자바 ",1,2,80,80,90));
        calculateSchoolRank(list);
        Iterator it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}



class Student119 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    int total;
    int schoolRank; // 전교등수
    int classRank; // 반등수
    Student119(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        total = kor+eng+math;
    }
    int getTotal() {
        return total;
    }
    float getAverage() {
        return (int)((getTotal()/ 3f)*10+0.5)/10f;
    }
    public int compareTo(Object o) {
        if(o instanceof Student119) {
            Student119 tmp = (Student119)o;
            return tmp.total - this.total;
        } else {
            return -1;
        }
    }
    public String toString() {
        return name
                +","+ban
                +","+no
                +","+kor
                +","+eng
                +","+math
                +","+getTotal()
                +","+getAverage()
                +","+schoolRank
                +","+classRank // 새로추가
                ;
    }
} // class Student119
class ClassTotalComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        //무조건 객체 비교할 땐, 묻지도 따지지도말고 형변환부터
        if(o1 instanceof Student119 && o2 instanceof Student119){
            Student119 st1191 = (Student119) o1;
            Student119 st1192 = (Student119) o2;

            // ClassTotalComparator가 어디에 쓰였는지 음영처리 된 내용들을 따라가봤더니 밑에 calculateClassRank에서 반별 총점기준으로 내림차순 정렬에 쓰고있다.
            // 즉 이 클래스는 반별 총점을 기준으로 비교할 수 있게 구현해놔야한다.
            return st1191.classRank>st1192.classRank ? 1 : -1;
        }
        // 안되면 묻따-1
        else{
            return -1;
        }
    }
}
class Exercise11_9 {
    public static void calculateClassRank(List list) {
// . 먼저 반별 총점기준 내림차순으로 정렬한다
        Collections.sort(list, new ClassTotalComparator());
        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();
        //1. list Student . 반복문을 이용해서 에 저장된 객체를 하나씩 읽는다
        for(int i=0; i<length; i++){
            Student119 stu119 = (Student119) list.get(i);

            //1.1 ,(ban prevBan ) 반이 달라지면 과 이 다르면
            //이전 등수 와 이전 총점 을 초기화한다 (prevRank) (prevTotal) .
            if(prevBan!= stu119.ban){
                prevRank = -1;
                prevTotal = -1;
            }
            //반이 같냐와 다르냐로 나뉜다.
            //여기는 반이 같다는 전에에서 진행된다.
            else{
                //1.2 (total) (prevTotal) 총점 이 이전총점 과 같으면
                //이전 등수 를 등수 로 한다 (prevRank) (classRank) .
                if(prevTotal== stu119.total){
                    stu119.classRank = prevRank;
                }
                //1.3 , 총점이 서로 다르면
                //등수 의 값을 알맞게 계산해서 저장한다 (classRank) .
                //이전에 동점자였다면 그 다음 등수는 동점자의 수를 고려해야 한다 , .
                //( 실행결과 참고)
                else{

                    // 지금 이 부분이 뭐가 잘못된지 한눈에 보이지않는다.
                    //일단 표시시
                   stu119.classRank = prevRank;
                }
                prevBan = stu119.ban;
                prevRank = stu119.classRank;
                prevTotal = stu119.total;
            }
        }

    } // public static void calculateClassRank(List list) {
    public static void calculateSchoolRank(List list) {
        Collections.sort(list, new ClassTotalComparator());
        int prevRank = -1; // 이전 전교등수
        int prevTotal = -1; // 이전 총점
        int length = list.size();
        //만약 동점이 나올 경우 list로 나오는 객체 수가 하나씩 나올때마다 증가하는 count로 등수를 바꿔주면 된다.
        int count = 1;

        // 1.   . 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다
        for(int i=0; i<length; i++){
            Student119 st118 = (Student119) list.get(i);

            // 1.1 (total) (prevTotal) 총점 이 이전총점 과 같으면
            //이전 등수 를 등수 로 한다 (prevRank) (schoolRank) .
            if(st118.total==prevTotal){
                st118.schoolRank = prevRank;
            }
            //1.2 , 총점이 서로 다르면
            //등수 의 값을 알맞게 계산해서 저장한다 (schoolRank) .
            //이전에 동점자 였다면 그 다음 등수는 동점자의 수를 고려해야 한다 , .
            //( ) 실행결과 참고
            else{
                //동점자는 어떻게 해야할지 몰라서 count로 바꿔줬다. 어짜피 사람 수만큼의 1등부터 꼴등까지 있어야한다.
                //그걸 동점자가 하나 가져가더라도 숫자가 그대로 증가하는 int 값이 하나 있으면 될거라고 생각했다.
                st118.schoolRank = count;

                prevTotal = st118.total;
                prevRank = st118.schoolRank;
            }
            count++;
        }

    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student119("이자바 ",2,1,70,90,70));
        list.add(new Student119("안자바 ",2,2,60,100,80));
        list.add(new Student119("홍길동 ",1,3,100,100,100));
        list.add(new Student119("남궁성 ",1,1,90,70,80));
        list.add(new Student119("김자바 ",1,2,80,80,90));
        calculateSchoolRank(list);
        calculateClassRank(list);
        Iterator it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}
