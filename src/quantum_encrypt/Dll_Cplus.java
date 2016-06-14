package quantum_encrypt;

public class Dll_Cplus {
    static {
        try {
            System.loadLibrary("Dll_Cplus"); // call dll  
        } catch (UnsatisfiedLinkError e) {
            System.out.println("The load problem");
        }
    }


    //位数选择
    public native void keyInstall(int select);

    //实时加密  地址：  E:\量子加密项目\Quantum\bin\txtwork.txt
    public native String txtEncrypt(String txt); //测试

    //实时解密
    public native String txtDissect(String txt);

    //加密  path为文件地址，在其他.java类调用本.java类中的函数时传参
    public native void Encrypt(String Path);

    //解密 
    public native void Dissect(String Path);
    //test
}
