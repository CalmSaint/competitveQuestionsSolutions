package hackerearth;

interface FuncInt {
    int getInput(int num1, int num2);
    default int getValue(){
    return 0;
    }

    }