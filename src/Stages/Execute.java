package Stages;

//import Components.ALU;
import Components.PipelineRegister;
import Components.RegisterFile;

public class Execute {
//    ALU ALUExecuted;
    private RegisterFile regFile;
    PipelineRegister prev;
    PipelineRegister next;
    String Opcode;
    String R1Value;
    String R2Value;
    String R3Value;
    String R1Address;
    String R2Address;
    String R3Address;
    String immediate;
    String writeAddress;
    String writeValue;
    boolean jump;
    boolean writeMem;
    boolean readMem;
    boolean writeReg;
    boolean equal;
    String jumpValue;
    

    public Execute(RegisterFile reg, Decode decode) {
        regFile = reg;
        this.prev = decode.next;
        this.next = new PipelineRegister(3);
        jump = false;
        settersFromPrev();
        int tempA = 0;
        int tempB = 0;

        switch (Opcode) {
        case "00010":
            tempA = Integer.parseInt(R1Value, 2) + Integer.parseInt(R2Value, 2);
            R1Value = Integer.toBinaryString(tempA);
            break;

        case "00011":
            tempA = Integer.parseInt(R1Value, 2) - Integer.parseInt(R2Value, 2);
            R1Value = Integer.toBinaryString(tempA);
            break;
        case "00100":
            writeAddress = R1Address;
            writeValue = immediate;
            break;
        case "00101":
            tempA = Integer.parseInt(R1Value, 2) >> Integer.parseInt(immediate, 2);
            R1Value = Integer.toBinaryString(tempA);
            writeValue = R1Value;
            writeAddress = R1Address;
            break;
        case "001110":
            tempA = Integer.parseInt(R1Value, 2) << Integer.parseInt(immediate, 2);
            R1Value = Integer.toBinaryString(tempA);
            writeValue = R1Value;
            writeAddress = R1Address;
            break;

        case "00111":
            tempA = Integer.parseInt(R1Value, 2) * Integer.parseInt(R2Value, 2);
            R3Value = Integer.toBinaryString(tempA);
            writeValue = R3Value;
            writeAddress = R3Address;
            break;
        case "01000":
            tempA = Integer.parseInt(R1Value, 2) / Integer.parseInt(R2Value, 2);
            R3Value = Integer.toBinaryString(tempA);
            writeValue = R3Value;
            writeAddress = R3Address;
            break;
        case "01001":
            tempA = Integer.parseInt(R1Value, 2) | Integer.parseInt(R2Value, 2);
            R3Value = Integer.toBinaryString(tempA);
            writeValue = R3Value;
            writeAddress = R3Address;
            break;

        case "01010":
            tempA = Integer.parseInt(R1Value, 2) & Integer.parseInt(R2Value, 2);
            R3Value = Integer.toBinaryString(tempA);
            writeValue = R3Value;
            writeAddress = R3Address;
            break;
        case "01100":
            tempA = ~Integer.parseInt(R1Value, 2);
            R2Value = Integer.toBinaryString(tempA);
            writeValue = R2Value;
            writeAddress = R2Address;
            break;
        case "01101":
            tempA = Integer.parseInt(R1Value, 2) ^ Integer.parseInt(R2Value, 2);
            R3Value = Integer.toBinaryString(tempA);
            writeValue = R3Value;
            writeAddress = R3Address;
            break;
            
        case "01110":
            //HERE COMES THANOS
            tempA=Integer.parseInt(R1Value,2)&(int)Math.random()*10000;
            R2Value=Integer.toBinaryString(tempA);
            writeValue=R2Value;

writeAddress=R2Address;
            break;
            
        case"10100":
        case "10101":
            equal= Integer.parseInt(R1Value, 2)== Integer.parseInt(R2Value, 2);
            break;
        }
        setterToNext();

}
        
    

    public void settersFromPrev() {

        Opcode = prev.getOpcode();
        R1Value = prev.getR1Value();
        R2Value = prev.getR2Value();
        R3Value = prev.getR3Value();
        R1Address = prev.getR1Address();
        R2Address = prev.getR2Address();
        R3Address = prev.getR3Address();
        immediate = prev.getImmediate();
        writeAddress = prev.getWriteAddress();
        writeValue = prev.getWriteAddress();
        jump = prev.isJump();
        writeMem = prev.isWriteMem();
        readMem = prev.isReadMem();
        writeReg = prev.isWriteReg();
        jumpValue=prev.getJumpValue();

    }

    public void setterToNext() {

        next.setOpcode(Opcode);
        next.setR1Value(R1Value);
        next.setR2Value(R2Value);
        next.setR3Value(R3Value);
        next.setR1Address(R1Address);
        next.setR2Address(R2Address);
        next.setR3Address(R3Address);
        next.setImmediate(immediate);
        next.setWriteAddress(writeAddress);
        next.setWriteValue(writeValue);
        next.setJump(jump);
        next.setWriteMem(writeMem);
        next.setReadMem(readMem);
        next.setReadMem(readMem);
        next.setJumpValue(jumpValue);
    }

//    public void run() {
//        settersFromPrev();
//        int tempA = 0;
//        int tempB = 0;
//
//        switch (Opcode) {
//        case "00010":
//            tempA = Integer.parseInt(R1Value, 2) + Integer.parseInt(R2Value, 2);
//            R1Value = Integer.toBinaryString(tempA);
//            break;
//
//        case "00011":
//            tempA = Integer.parseInt(R1Value, 2) - Integer.parseInt(R2Value, 2);
//            R1Value = Integer.toBinaryString(tempA);
//            break;
//        case "00100":
//            writeAddress = R1Address;
//            writeValue = immediate;
//            break;
//        case "00101":
//            tempA = Integer.parseInt(R1Value, 2) >> Integer.parseInt(immediate, 2);
//            R1Value = Integer.toBinaryString(tempA);
//            writeValue = R1Value;
//            writeAddress = R1Address;
//            break;
//        case "001110":
//            tempA = Integer.parseInt(R1Value, 2) << Integer.parseInt(immediate, 2);
//            R1Value = Integer.toBinaryString(tempA);
//            writeValue = R1Value;
//            writeAddress = R1Address;
//            break;
//
//        case "00111":
//            tempA = Integer.parseInt(R1Value, 2) * Integer.parseInt(R2Value, 2);
//            R3Value = Integer.toBinaryString(tempA);
//            writeValue = R3Value;
//            writeAddress = R3Address;
//            break;
//        case "01000":
//            tempA = Integer.parseInt(R1Value, 2) / Integer.parseInt(R2Value, 2);
//            R3Value = Integer.toBinaryString(tempA);
//            writeValue = R3Value;
//            writeAddress = R3Address;
//            break;
//        case "01001":
//            tempA = Integer.parseInt(R1Value, 2) | Integer.parseInt(R2Value, 2);
//            R3Value = Integer.toBinaryString(tempA);
//            writeValue = R3Value;
//            writeAddress = R3Address;
//            break;
//
//        case "01010":
//            tempA = Integer.parseInt(R1Value, 2) & Integer.parseInt(R2Value, 2);
//            R3Value = Integer.toBinaryString(tempA);
//            writeValue = R3Value;
//            writeAddress = R3Address;
//            break;
//        case "01100":
//            tempA = ~Integer.parseInt(R1Value, 2);
//            R2Value = Integer.toBinaryString(tempA);
//            writeValue = R2Value;
//            writeAddress = R2Address;
//            break;
//        case "01101":
//            tempA = Integer.parseInt(R1Value, 2) ^ Integer.parseInt(R2Value, 2);
//            R3Value = Integer.toBinaryString(tempA);
//            writeValue = R3Value;
//            writeAddress = R3Address;
//            break;
//            
//        case "01110":
//            //HERE COMES THANOS
//            tempA=Integer.parseInt(R1Value,2)&(int)Math.random()*10000;
//            R2Value=Integer.toBinaryString(tempA);
//            writeValue=R2Value;
//
//writeAddress=R2Address;
//            break;
//            
//        case"10100":
//        case "10101":
//            equal= Integer.parseInt(R1Value, 2)== Integer.parseInt(R2Value, 2);
//            break;
//        }
//
//}
}