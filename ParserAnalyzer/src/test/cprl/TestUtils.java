/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cprl;


import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.compiler.Source;
import edu.citadel.cprl.Parser;
import edu.citadel.cprl.ast.AST;
import edu.citadel.cprl.ast.Program;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

/**
 * Métodos utilitários para os testes.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TestUtils {
    
    // <editor-fold defaultstate="collapsed" desc="Dados dos Testes (não mexa!)">
        
    public static String[] titulos = { 
            "TesteHello",
            "TesteCorrect_101",
            "TesteCorrect_102",
            "TesteCorrect_103",
            "TesteCorrect_104",
            "TesteCorrect_105",
            "TesteCorrect_106",
            "TesteCorrect_107",
            "TesteCorrect_108",
            "TesteCorrect_109",
            "TesteCorrect_110",
            "TesteCorrect_111",
            "TesteCorrect_112",
            "TesteCorrect_113",
            "TesteCorrect_114",
            "TesteCorrect_115",
            "TesteCorrect_116",
            "TesteCorrect_117",
            "TesteCorrect_118",
            "TesteCorrect_119",
            "TesteCorrect_120",
            "TesteCorrect_121",
            "TesteCorrect_122",
            "TesteCorrect_123",
            "TesteCorrect_124",
            "TesteCorrect_125",
            "TesteGCD0",
            "TesteCorrect_201",
            "TesteCorrect_202",
            "TesteCorrect_203",
            "TesteCorrect_204",
            "TesteCorrect_205",
            "TesteCorrect_206",
            "TesteCorrect_207",
            "TesteCorrect_208",
            "TesteCorrect_209",
            "TesteCorrect_210",
            "TesteCorrect_211",
            "TesteCorrect_212",
            "TesteCorrect_213",
            "TesteCorrect_214",
            "TesteCorrect_215",
            "TesteGCD",
            "TesteInc",
            "TesteMax",
            "TesteAbs",
            "TesteComposition",
            "TesteReverse",
            "TesteHanoi",
            "TesteCorrect_301",
            "TesteCorrect_302",
            "TesteCorrect_303",
            "TesteCorrect_304",
            "TesteCorrect_401",
            "TesteQuickSort",
            "TesteSort",
            "TesteIncorrect_101",
            "TesteIncorrect_102",
            "TesteIncorrect_103",
            "TesteIncorrect_104",
            "TesteIncorrect_105",
            "TesteIncorrect_106",
            "TesteIncorrect_107",
            "TesteIncorrect_108",
            "TesteIncorrect_109",
            "TesteIncorrect_110",
            "TesteIncorrect_111",
            "TesteIncorrect_112",
            "TesteIncorrect_113",
            "TesteIncorrect_114",
            "TesteIncorrect_115",
            "TesteIncorrect_116",
            "TesteIncorrect_117",
            "TesteIncorrect_118",
            "TesteIncorrect_119",
            "TesteIncorrect_120",
            "TesteIncorrect_121",
            "TesteIncorrect_122",
            "TesteIncorrect_123",
            "TesteIncorrect_124",
            "TesteIncorrect_125",
            "TesteIncorrect_126",
            "TesteIncorrect_127",
            "TesteIncorrect_128",
            "TesteIncorrect_129",
            "TesteIncorrect_201",
            "TesteIncorrect_202",
            "TesteIncorrect_203",
            "TesteIncorrect_204",
            "TesteIncorrect_205",
            "TesteIncorrect_206",
            "TesteIncorrect_207",
            "TesteIncorrect_208",
            "TesteIncorrect_209",
            "TesteIncorrect_210",
            "TesteIncorrect_211",
            "TesteIncorrect_212",
            "TesteIncorrect_213",
            "TesteIncorrect_214",
            "TesteIncorrect_215",
            "TesteIncorrect_216",
            "TesteIncorrect_217",
            "TesteIncorrect_218",
            "TesteIncorrect_219",
            "TesteIncorrect_220",
            "TesteIncorrect_221",
            "TesteIncorrect_222",
            "TesteIncorrect_301",
            "TesteIncorrect_302",
            "TesteIncorrect_303",
            "TesteIncorrect_304",
            "TesteIncorrect_305"
    };

    public static String[] caminhosFontes = {
            "../examples/Correct/CPRL0/Hello.cprl",
            "../examples/Correct/CPRL0/Correct_101.cprl",
            "../examples/Correct/CPRL0/Correct_102.cprl",
            "../examples/Correct/CPRL0/Correct_103.cprl",
            "../examples/Correct/CPRL0/Correct_104.cprl",
            "../examples/Correct/CPRL0/Correct_105.cprl",
            "../examples/Correct/CPRL0/Correct_106.cprl",
            "../examples/Correct/CPRL0/Correct_107.cprl",
            "../examples/Correct/CPRL0/Correct_108.cprl",
            "../examples/Correct/CPRL0/Correct_109.cprl",
            "../examples/Correct/CPRL0/Correct_110.cprl",
            "../examples/Correct/CPRL0/Correct_111.cprl",
            "../examples/Correct/CPRL0/Correct_112.cprl",
            "../examples/Correct/CPRL0/Correct_113.cprl",
            "../examples/Correct/CPRL0/Correct_114.cprl",
            "../examples/Correct/CPRL0/Correct_115.cprl",
            "../examples/Correct/CPRL0/Correct_116.cprl",
            "../examples/Correct/CPRL0/Correct_117.cprl",
            "../examples/Correct/CPRL0/Correct_118.cprl",
            "../examples/Correct/CPRL0/Correct_119.cprl",
            "../examples/Correct/CPRL0/Correct_120.cprl",
            "../examples/Correct/CPRL0/Correct_121.cprl",
            "../examples/Correct/CPRL0/Correct_122.cprl",
            "../examples/Correct/CPRL0/Correct_123.cprl",
            "../examples/Correct/CPRL0/Correct_124.cprl",
            "../examples/Correct/CPRL0/Correct_125.cprl",
            "../examples/Correct/CPRL0/GCD0.cprl",
            "../examples/Correct/Subprograms/Correct_201.cprl",
            "../examples/Correct/Subprograms/Correct_202.cprl",
            "../examples/Correct/Subprograms/Correct_203.cprl",
            "../examples/Correct/Subprograms/Correct_204.cprl",
            "../examples/Correct/Subprograms/Correct_205.cprl",
            "../examples/Correct/Subprograms/Correct_206.cprl",
            "../examples/Correct/Subprograms/Correct_207.cprl",
            "../examples/Correct/Subprograms/Correct_208.cprl",
            "../examples/Correct/Subprograms/Correct_209.cprl",
            "../examples/Correct/Subprograms/Correct_210.cprl",
            "../examples/Correct/Subprograms/Correct_211.cprl",
            "../examples/Correct/Subprograms/Correct_212.cprl",
            "../examples/Correct/Subprograms/Correct_213.cprl",
            "../examples/Correct/Subprograms/Correct_214.cprl",
            "../examples/Correct/Subprograms/Correct_215.cprl",
            "../examples/Correct/Subprograms/GCD.cprl",
            "../examples/Correct/Subprograms/Inc.cprl",
            "../examples/Correct/Subprograms/Max.cprl",
            "../examples/Correct/Subprograms/Abs.cprl",
            "../examples/Correct/Subprograms/Composition.cprl",
            "../examples/Correct/Subprograms/Reverse.cprl",
            "../examples/Correct/Subprograms/Hanoi.cprl",
            "../examples/Correct/Arrays/Correct_301.cprl",
            "../examples/Correct/Arrays/Correct_302.cprl",
            "../examples/Correct/Arrays/Correct_303.cprl",
            "../examples/Correct/Arrays/Correct_304.cprl",
            "../examples/Correct/ArraysAndProcedures/Correct_401.cprl",
            "../examples/Correct/ArraysAndProcedures/QuickSort.cprl",
            "../examples/Correct/ArraysAndProcedures/Sort.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_101.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_102.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_103.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_104.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_105.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_106.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_107.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_108.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_109.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_110.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_111.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_112.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_113.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_114.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_115.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_116.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_117.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_118.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_119.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_120.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_121.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_122.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_123.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_124.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_125.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_126.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_127.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_128.cprl",
            "../examples/Incorrect/CPRL0/Incorrect_129.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_201.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_202.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_203.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_204.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_205.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_206.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_207.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_208.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_209.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_210.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_211.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_212.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_213.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_214.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_215.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_216.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_217.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_218.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_219.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_220.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_221.cprl",
            "../examples/Incorrect/Subprograms/Incorrect_222.cprl",
            "../examples/Incorrect/Arrays/Incorrect_301.cprl",
            "../examples/Incorrect/Arrays/Incorrect_302.cprl",
            "../examples/Incorrect/Arrays/Incorrect_303.cprl",
            "../examples/Incorrect/Arrays/Incorrect_304.cprl",
            "../examples/Incorrect/Arrays/Incorrect_305.cprl"
    };// </editor-fold>
    
    /*
     * Executa um teste comparando a saída do escaneamento de um arquivo de
     * código fonte e um arquivo de resultado.
     */
    public static void testar( 
            String titulo, 
            String caminhoFonte, 
            String caminhoResultado ) throws FileNotFoundException, IOException {
        
        System.out.println( titulo );
        String expResult = carregar( caminhoResultado );
        String result = gerar( caminhoFonte );
        
        result = result.replace( "\r", "" );
        expResult = expResult.replace( "\r", "" );
        
        System.out.println( "\n\n*********** Resultado:" );
        System.out.println( result );
        
        System.out.println( "\n\n*********** Esperado:" );
        System.out.println( expResult );
        
        assertEquals( expResult, result );
        
    }
    
    public static void testarVarios( 
            String[] titulos, 
            String[] caminhosFontes, 
            boolean executarTestesDeUnidade ) throws FileNotFoundException, IOException {
        
        int total = titulos.length;
        int corretos = 0;
        
        try ( 
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream( baos, true, StandardCharsets.UTF_8 ) ) {
            
            PrintStream ant = System.out;
            System.setOut( ps );
            
            String resultadosFinais = "";
            
            // coleta todas as compilações e resultados
            for ( int i = 0; i < titulos.length; i++ ) {
                
                String titulo = titulos[i];
                String caminhoFonte = caminhosFontes[i];
                
                System.err.println( "Processando " + titulo );
                
                executar( caminhoFonte );
                System.out.println( "---fim---" );
                System.out.flush();

            }
            
            resultadosFinais = baos.toString().trim();
            resultadosFinais = resultadosFinais.replace( "\r", "" );
            
            System.setOut( ant );
            
            Map<String, String> resultadosEsperados = carregarResultados();
            int i = 0;
            
            for ( String resultado : resultadosFinais.split( "---fim---" ) ) {
                
                resultado = resultado.trim();
                
                System.out.println( "#### Testando " + titulos[i] + " ####" );
                String expResult = resultadosEsperados.get( titulos[i] );
                
                if ( executarTestesDeUnidade ) {

                    System.out.println( "*********** Resultado:" );
                    System.out.println( resultado );

                    System.out.println( "\n*********** Esperado:" );
                    System.out.println( expResult );
                    
                    assertEquals( expResult, resultado );
                    System.out.println( "\n### " + titulos[i] + " ok! ###\n" );
                    System.out.println( "------------------------------------\n\n");
                    
                } else {
                    
                    boolean correto = expResult.equals( resultado );
                    
                    if ( correto ) {
                        corretos++;
                        System.out.println( "correto!" );
                    } else {
                        System.out.println( "errado!" );
                    }
                    
                }
                
                i++;
                
            }
            
            if ( !executarTestesDeUnidade ) {
                System.out.println( "   Total: " + total );
                System.out.println( "Corretos: " + corretos );
                System.out.println( "    Nota: " + (double) corretos / total * 10.0 );
            }
        
        }
        
    }
    
    /*
     * Carrega um arquivo de solução e retorna a String com o conteúdo do mesmo.
     */
    private static String carregar( String path ) throws FileNotFoundException, IOException {
        
        StringBuilder expResultBuilder = new StringBuilder();
        try ( Scanner s = new Scanner( new File( path ), StandardCharsets.UTF_8 ) ) {
            while ( s.hasNextLine() ) {
                expResultBuilder.append( s.nextLine() ).append( "\n" );
            }
            return expResultBuilder.toString().trim();
        }
        
    }
    
    /*
     * Carrega um arquivo de solução geral e retorna um mapa com o conteúdo do
     * mesmo associando os títulso com os conteúdos esperados.
     */
    public static Map<String, String> carregarResultados() throws FileNotFoundException, IOException {
        
        StringBuilder expResultBuilder = new StringBuilder();
        
        try ( Scanner s = new Scanner( new File( "../examples/cprl_full Results - projeto.txt" ), StandardCharsets.UTF_8 ) ) {
            while ( s.hasNextLine() ) {
                expResultBuilder.append( s.nextLine() ).append( "\n" );
            }
        }
        
        Map<String, String> r = new LinkedHashMap<>();
        
        for ( String s : expResultBuilder.toString().replace( "\r", "" ).trim().split( "<sep>" ) ) {
            s = s.trim();
            r.put( s.split( "\n" )[0].replace( "Starting compilation for ", "Teste" ).replace( ".cprl...", "" ).trim(), s );
        }
        
        return r;
        
    }
    
    /*
     * Executa o Parser em um arquivo de código fonte e retorna toda a saída
     * gerada pelo mesmo na saída padrão em uma String.
     */
    private static String gerar( String path ) throws IOException {
        
        try ( 
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream( baos, true, StandardCharsets.UTF_8 ) ) {
            
            PrintStream ant = System.out;
            System.setOut( ps );
            
            executar( path );
            System.out.flush();
            
            System.setOut( ant );
            
            return baos.toString().trim();
            
        }
        
    }
    
    public static void executar( String fileName ) throws IOException {
        
        File sourceFile = new File( fileName );
        FileReader reader = new FileReader( sourceFile, StandardCharsets.UTF_8 );
        Source source = new Source( reader );
        edu.citadel.cprl.Scanner scanner = new edu.citadel.cprl.Scanner( source );
        Parser parser = new Parser( scanner );

        ErrorHandler errorHandler = ErrorHandler.getInstance();
        
        System.out.println( "Starting compilation for " + sourceFile.getName() + "..." );
        
        Program program = parser.parseProgram();

        if ( !errorHandler.errorsExist() ) {
            System.out.println( "Checking constraints..." );
            program.checkConstraints();
        }

        if ( !errorHandler.errorsExist() ) {
            
            System.out.println( "Generating code..." );

            try {
                
                // por padrão AST direcionará a emissão do código gerado
                // na saída padrão
                
                //AST.setPrintWriter( getTargetPrintWriter( sourceFile ) );
                
                program.emit();
                
            } catch ( CodeGenException ex ) {
                errorHandler.reportError( ex );
            }
            
        }

        if ( errorHandler.errorsExist() ) {
            errorHandler.printMessage( "Errors detected in " + sourceFile.getName()
                    + " -- compilation terminated." );
        } else {
            System.out.println( "Compilation complete." );
        }
        
        ErrorHandler.getInstance().resetErrorCount();
        AST.resetCurrentLabelNum();
        reader.close();
        
    }
    
    public static void testeEmLote( int[] intervalos, boolean executarTestesDeUnidade ) throws IOException, FileNotFoundException {
        
        List<String> titulosL = new ArrayList<>();
        List<String> caminhosFontesL = new ArrayList<>();
        
        for ( int i = 0; i < intervalos.length; i += 2 ) {
            int inicio = intervalos[i];
            int fim = intervalos[i+1];
            for ( int j = inicio; j <= fim; j++ ) {
                titulosL.add( titulos[j-1] );
                caminhosFontesL.add( caminhosFontes[j-1] );
            }
        }
        
        testarVarios( 
                titulosL.toArray( new String[0] ), 
                caminhosFontesL.toArray( new String[0] ),
                executarTestesDeUnidade );
        
    }
    
    private static PrintWriter getTargetPrintWriter( File sourceFile ) {
        
        String baseName = sourceFile.getName();
        int suffixIndex = baseName.lastIndexOf( ".cprl" );
        if ( suffixIndex > 0 ) {
            baseName = sourceFile.getName().substring( 0, suffixIndex );
        }

        String targetFileName = baseName + ".asm";

        try {
            File targetFile = new File( sourceFile.getParent(), targetFileName );
            return new PrintWriter( new FileWriter( targetFile, StandardCharsets.UTF_8 ), true );
        } catch ( IOException e ) {
            e.printStackTrace();
            System.exit( -1 );
            return null;   // will never execute
        }
    }
    
}
