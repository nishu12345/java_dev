class InstanceVsStatic{
  static int x = 10;
  int y = 20;
  public static void main(String[] args) {
    InstanceVsStatic instanceVsStatic1 = new InstanceVsStatic();
    instanceVsStatic1.x = 888;
    instanceVsStatic1.y = 999;

    InstanceVsStatic instanceVsStatic2 = new InstanceVsStatic();
    System.out.println(instanceVsStatic2.x + "....." + instanceVsStatic2.y);
  }
}
