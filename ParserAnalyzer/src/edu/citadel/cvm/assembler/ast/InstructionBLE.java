package edu.citadel.cvm.assembler.ast;

import edu.citadel.compiler.ConstraintException;
import edu.citadel.cvm.Constants;
import edu.citadel.cvm.OpCode;
import edu.citadel.cvm.assembler.Symbol;
import edu.citadel.cvm.assembler.Token;

import java.util.List;
import java.io.IOException;

/**
 * This class implements the abstract syntax tree for the assembly language
 * instruction BLE.
 */
public class InstructionBLE extends InstructionOneArg {

    public InstructionBLE( List<Token> labels, Token opCode, Token arg ) {
        super( labels, opCode, arg );
    }

    public void assertOpCode() {
        assertOpCode( Symbol.BLE );
    }

    public void checkArgType() throws ConstraintException {
        checkArgType( Symbol.identifier );
        checkLabelArgDefined();
    }

    public int getArgSize() {
        return Constants.BYTES_PER_INTEGER;
    }

    @Override
    public void emit() throws IOException {
        emit( OpCode.BLE );
        emit( getDisplacement( getArg() ) );
    }
}
