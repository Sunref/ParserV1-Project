/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cprl;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static test.cprl.TestUtils.testar;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class TesteIncorrect303 {
    
    @Test
    public void testeIncorrect303() throws IOException, FileNotFoundException {
        
        testar( "TesteIncorrect_303",
                "../examples/Incorrect/Arrays/Incorrect_303.cprl",
                "../examples/Incorrect/Arrays/Incorrect_303-ParserV1-Results.txt" );
        
    }
    
}
