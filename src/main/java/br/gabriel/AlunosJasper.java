package br.gabriel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class AlunosJasper {

    public void alunos() throws JRException {

        String jrxml = "alunos.jrxml";

        String jasper = JasperCompileManager.compileReportToFile(jrxml);

        System.out.println(jasper); // alunos.jasper
    }
}
