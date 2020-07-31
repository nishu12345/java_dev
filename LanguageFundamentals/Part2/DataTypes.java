class DataTypes{
	public static void main(String... s){
		byte b = 10;
		byte c = 127;
		byte d = (byte)-129; 	//value underflow will occur while explicit type conversion.
		System.out.println(d); 	// It will print 127.
		// byte d = 128; 		, 	CE:- possible loss of precision from int to byte.
		// byte e = 10.5; 		, 	CE:- possible loss of precision from double to byte.
		// byte f = true; 		, 	CE:- incompatible types.
		// byte g = "nishant"; 	, 	CE:- incompatible types.
		// int x = 2147483648; 	, 	CE:- integer number too large.
		// int y = 2147483648l;	,	CE:- possible loss of precision from long to int.
	}
}