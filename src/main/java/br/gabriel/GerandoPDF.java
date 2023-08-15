package br.gabriel;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GerandoPDF {

    public static void main(String[] args) {


        try {
            String jrxml = "src/main/java/br/gabriel/relatorios/financas_v3.jrxml";
            Map<String, Object> parametros = new HashMap<>();
            OutputStream saida = new FileOutputStream("C:\\pix\\pdfs\\financas"+ UUID.randomUUID().toString() +".pdf");

// compila jrxml em um arquivo .jasper
            String jasper = JasperCompileManager.compileReportToFile(jrxml);

// preenche relatorio
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros);

// exporta para pdf
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);
            exporter.exportReport();
        } catch (Exception e){

        }


    }
}
