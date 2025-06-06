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
 * instruction LDCCH.
 */
public class InstructionLDCCH extends InstructionOneArg {

    public InstructionLDCCH( List<Token> labels, Token opCode, Token arg ) {
        super( labels, opCode, arg );
    }

    public void assertOpCode() {
        assertOpCode( Symbol.LDCCH );
    }

    public void checkArgType() throws ConstraintException {
        checkArgType( Symbol.charLiteral );
    }

    public int getArgSize() {
        return Constants.BYTES_PER_CHAR;
    }

    @Override
    public void emit() throws IOException {
        char arg = getArg().getText().charAt( 1 );

        emit( OpCode.LDCCH );
        emit( arg );
    }
}
