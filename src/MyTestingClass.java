public class MyTestingClass {
    private String name;
    public MyTestingClass(String name){
        this.name=name;
    }
    @Override
    public int hashCode(){
        int hash=1;
        if(name==null){
            return -1;
        }
        char[] array=name.toCharArray();
        for(int i=0;i< array.length;i++){
            hash=21*hash+(int)array[i];
        }
        return hash;
    }
}
