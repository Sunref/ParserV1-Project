package edu.citadel.cvm.assembler.ast;

import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cvm.assembler.optimize.Optimization;
import edu.citadel.cvm.assembler.optimize.Optimizations;

import java.io.IOException;
import java.util.*;

/**
 * This class implements the abstract syntax tree for an assembly language
 * program.
 */
public class Program extends AST {

    private ArrayList<Instruction> instructions;

    public Program() {
        super();
        instructions = new ArrayList<Instruction>( 200 );
    }

    public void addInstruction( Instruction inst ) {
        instructions.add( inst );
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    @Override
    public void checkConstraints() {
        for ( Instruction inst : instructions ) {
            inst.checkConstraints();
        }
    }

    /**
     * Perform code transformations that improve performance. This method is
     * normally called after checkConstraints() and before emit();
     */
    public void optimize() {
        List<Optimization> optimizations = Optimizations.getOptimizations();

        for ( int n = 0; n < instructions.size(); ++n ) {
            for ( Optimization optimization : optimizations ) {
                optimization.optimize( instructions, n );
            }
        }
    }

    /**
     * Sets the starting memory address for each instruction and defines label
     * addresses. Note: This method should be called after optimizations have
     * been performed and immediately before code generation.
     */
    public void setAddresses() {
        // the starting address for the first instruction
        int address = 0;

        for ( Instruction inst : instructions ) {
            try {
                inst.setAddress( address );
                address += inst.getSize();
            } catch ( ConstraintException e ) {
                ErrorHandler.getInstance().reportError( e );
            }
        }
    }

    @Override
    public void emit() throws IOException {
        for ( Instruction inst : instructions ) {
            inst.emit();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer( 1000 );

        for ( Instruction inst : instructions ) {
            buffer.append( inst.toString() )
                    .append( "\n" );
        }

        return buffer.toString();
    }
}
