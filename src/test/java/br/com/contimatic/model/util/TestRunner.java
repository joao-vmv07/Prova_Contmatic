package br.com.contimatic.model.util;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import br.com.contmatic.model.empresa.ClienteTest;
import br.com.contmatic.model.empresa.EmpresaTest;
import br.com.contmatic.model.empresa.FuncionarioTest;
import br.com.contmatic.model.endereco.EnderecoTest;
import br.com.contmatic.model.telefone.TelefoneTest; 

@SuiteDisplayName("SUITE TEST RUNNER EXECUTADO:")
@SelectPackages({"br.com.model.empresa"})
@SelectClasses({EmpresaTest.class, FuncionarioTest.class, ClienteTest.class, TelefoneTest.class, EnderecoTest.class})
@Suite
public class TestRunner {
	
}
