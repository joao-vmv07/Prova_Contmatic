package br.com.contimatic.model.util;

import static br.com.contmatic.model.endereco.EstadoUF.SP;
import static br.com.contmatic.model.telefone.TelefoneType.CELULAR;
import static br.com.six2six.fixturefactory.Fixture.of;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ModelTempleateLoader implements TemplateLoader {

    @Override
    public void load() {
        of(Empresa.class).addTemplate("valid", new Rule() {
            {
                add("cnpj", random("66642331000133","50449153000199","91158295000184"));
                add("razaoSocial", "VIVO LTDA");
                add("nomeFantasia", "VIVO");
                add("telefones", has(1).of(Telefone.class, "valid"));
                add("enderecos", has(1).of(Endereco.class, "valid"));
            }
        });
        of(Funcionario.class).addTemplate("valid", new Rule() {
            {
                add("cpf", "73738802070");
                add("nome", "Funcionario A");
                add("email", "funcionarioA@gmail.com.br");
                add("idade", "19");
                add("dataNascimento", new LocalDate(2003, 3, 7));
                add("status", true);
                add("salario", new BigDecimal("2000.00"));
            }
        });
        of(Telefone.class).addTemplate("valid", new Rule() {
            {
                add("ddd", "11");
                add("numero", "967976463");
                add("ddi", "55");
                add("telefoneType", CELULAR);
            }
        });
        of(Endereco.class).addTemplate("valid", new Rule() {
            {
                add("numero", 11);
                add("logradouro", "RUA");
                add("bairro", "TATUAPE");
                add("cep", "04852505");
                add("pais", "Brasil");
                add("uf", "SP");
                add("municipio", "São Paulo");
                add("estadoUF", SP);
            }
        });
    }
}
