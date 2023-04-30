public class MyTestingClass {
    private String name;
    public MyTestingClass(String name){
        this.name=name;
    }
    @Override
    public int hashCode(){
        int hash=0;
        char[] array=name.toCharArray();
        for(int i=0;i< array.length;i++){
            hash+=(int)array[i];
        }
        return hash;
    }
}
