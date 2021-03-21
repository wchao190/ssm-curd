public class TestCharType{
	public static void main(String[] args){
		char a = 'a';
		for(int i=0;i<26;i++){
			char temp = (char)(a+i);
			System.out.println(temp);
		}
	}
}