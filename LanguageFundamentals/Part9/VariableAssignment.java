class VariableAssignment{
  public static void main(String[] args) {
    /*
    Element level promotion is not valid in case of arrays.
    char type can be implicitly promoted to int type. But,
    char[] type can't be promoted to int[] type.
    char[] ch = {'a','b'};
    int[] x = ch;
    */

    /*
    For objects type arrays, child class can be promoted to
    parent class.
    */
    String[] vowels = {"a","e","i","o","u"};
    Object[] objects = vowels;

    /*
    When assigning one array to another array, the dimmensions must match.
    */
    int[][] a1 = new int[3][];
    // a1[0] = new int[2][3];   compile time error, incompatible types
    // a1[0] = 10;              compile time error, incompatible types
    a1[0] = new int[2];
  }
}
