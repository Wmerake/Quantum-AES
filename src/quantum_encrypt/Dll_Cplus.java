package quantum_encrypt;

public class Dll_Cplus {
    static {
        try {
            System.loadLibrary("Dll_Cplus"); // call dll  
        } catch (UnsatisfiedLinkError e) {
            System.out.println("The load problem");
        }
    }

    //λ��ѡ��
    public native void keyInstall(int select);

    //ʵʱ����  ��ַ��  E:\���Ӽ�����Ŀ\Quantum\bin\txtwork.txt
    public native String txtEncrypt(String txt); //����

    //ʵʱ����
    public native String txtDissect(String txt);

    //����  pathΪ�ļ���ַ��������.java����ñ�.java���еĺ���ʱ����
    public native void Encrypt(String Path);

    //����
    public native void Dissect(String Path);
    //test
}
