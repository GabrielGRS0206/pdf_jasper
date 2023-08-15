package br.gabriel;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TesteGeraRelatorio {

    public static void main(String[] args) throws JRException, FileNotFoundException, JRException {

        // Gerando o relatório.
        String arquivo = "financas_v3";
        // Testando se o arquivo compilado existe. Ele é necessário para se criar o PDF.
//        File tmp = new File("src/main/java/br/gabriel/relatorios/"+arquivo+".jasper");
//
//        if (!tmp.exists()) { // Arquivo não existe ainda. Relatório não foi compilado.
//            JasperCompileManager.compileReportToFile("src/main/java/br/gabriel/relatorios/"+arquivo+".jrxml"); // Compilando antes.
//        }

        // Criando conexão com o banco de dados.

        // Criando o HashMap de parâmetros.
        Map<String, Object> params  = new HashMap<String, Object>();
        params.put("campo","TESTE");


        JasperPrint jPrint = JasperFillManager.fillReport("src/main/java/br/gabriel/relatorios/"+arquivo+".jasper", params);

//        String jPrint = JasperFillManager.fillReportToFile("src/main/java/br/gabriel/relatorios/"+arquivo+".jasper", params);
//        JasperFillManager.fillReportToFile()


        // Criando objeto que gerencia a  exportação
        JRPdfExporter exporter = new JRPdfExporter();


        // Setando as configurações de entrada e saída no objeto que gerencia a exportação
        exporter.setExporterInput(new SimpleExporterInput(jPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("C:\\pix\\pdfs\\financas"+ UUID.randomUUID().toString() +".pdf"));

        // Gravando o PDF.
        exporter.exportReport();

    }

//    public static void main(String[] args) {
//
//        try {
//            HashMap params = new HashMap<>();
//            params.put("campo", "test");
//
//            String nome = "financas_v3";
//
//            File tmp = new File("src/main/java/br/gabriel/relatorios/financas_v3.jasper");
//
//            URL arquivo = TesteGeraRelatorio.class.getResource(tmp.getAbsolutePath());
//            JasperReport jreport = (JasperReport) JRLoader.loadObject(arquivo);
//            JasperPrint jprint = JasperFillManager.fillReport(jreport, params);
//
//// Gerando o pdf
//            JasperExportManager.exportReportToPdfFile(jprint, "C:\\pix\\pdfs\\financas"+ UUID.randomUUID().toString() +".pdf");
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//    }

    /*
    // Gerando um relatório com parâmetros
HashMap params = new HashMap<>();
params.put("nomeParametro", inputDoParametro);

URL arquivo = getClass().getResource("/com/seuprograma/seupackage/relatorio.jasper");
JasperReport jreport = (JasperReport) JRLoader.loadObject(arquivo);
JasperPrint jprint = JasperFillManager.fillReport(jreport, params, JDBCconnection);

// Gerando o pdf
JasperExportManager.exportReportToPdfFile(jprint, file.getPath());

    */
}
