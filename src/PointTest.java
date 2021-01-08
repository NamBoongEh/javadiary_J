 class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        Point(){
            this(1, 1);
            // this.x=1;
            // this.y=1;
        }

        static double getDistance(Point p1, Point p2){
            return Math.sqrt(Math.pow(p2.x- p1.x,2)+Math.pow(p2.y-p1.y,2));
        }

        double getDistance(Point p2){
            return Point.getDistance(this,p2);
            // 위와 중복. 인스턴스객체는 iv 사용하고 static은 못사용
            // 그럼 인스턴스가 스태틱 메서드를 가져옴
        }

        //this 객체 자신 vs obj 같은지 비교
        //p.equals(p2) 호출
        public boolean equals(Object obj){
            // obj에는 x가 없다. 그래서 point로 형변환 필요
            Point p = (Point) obj;
//            if(this.x==p.x && this.y==p.y){
//                return true;
//            }
//            else{
//                return false;
//            }
            if(obj instanceof Point) {
                return this.x == p.x && this.y == p.y;
            }
            else{
                return false;
            }
        }
}
public class PointTest{
    public static void main(String[] args) {
        Point p = new Point(3, 5);
        Point p2 = new Point(1, 1);

        System.out.println(Point.getDistance(p, p2));
        System.out.println(p.x);
        System.out.println(p.y);
        System.out.println(p.toString());
        System.out.println(p.equals(p2));

    }
}
//
//class Point3D extends Point{
//    //조상 클래스 초기화는 조상이
//    Point3D(int x, int y, int z) {
//        super(x, y);
//        this.z = z;
//    }
//
//    Point3D(){
//        this(1,1,1);
//    }
//
//    public String toString(){
//        return super.toString()+" "+z;
//    }
//}