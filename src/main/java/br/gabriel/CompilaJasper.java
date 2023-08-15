package br.gabriel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class CompilaJasper {

    public static void main(String[] args) {

        String jrxml = "src/main/java/br/gabriel/relatorios/financas_v3.jrxml";

        String jasper = null;
        try {
            jasper = JasperCompileManager.compileReportToFile(jrxml);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jasper); // alunos.jasper
    }
}
