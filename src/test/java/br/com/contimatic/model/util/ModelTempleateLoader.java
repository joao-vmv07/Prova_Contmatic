package br.com.contimatic.model.util;

import static br.com.contmatic.model.telefone.TelefoneType.CELULAR;
import static br.com.six2six.fixturefactory.Fixture.of;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import br.com.contmatic.model.empresa.Cliente;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ModelTempleateLoader implements TemplateLoader {

    @Override
    public void load() {
        LocalDateTime DATA_CRIACAO = new LocalDateTime(2023, 1 , 21, 11 , 11);
        LocalDateTime DATA_ALTERACAO = LocalDateTime.now();
        of(Empresa.class).addTemplate("valid", new Rule() {
            {
                add("cnpj", random("66642331000133", "50449153000199", "91158295000184"));
                add("razaoSocial", "VIVO LTDA");
                add("nomeFantasia", "VIVO");
                add("telefones", has(1).of(Telefone.class, "valid"));
                add("enderecos", has(1).of(Endereco.class, "valid"));
                add("usuarioCriacao", "Empresa A");
                add("usuarioAlteracao", "Empresa B");
                add("dataCriacao", DATA_CRIACAO);
                add("dataAlteracao", DATA_ALTERACAO);
            } 
        });
        of(Funcionario.class).addTemplate("valid", new Rule() {
            {
                add("cpf", "73738802070");
                add("nome", "Funcionario A");
                add("email", "funcionario@gmail.com");
                add("idade", "19");
                add("dataNascimento", new LocalDate(2003, 3, 7));
                add("status", true);
                add("salario", new BigDecimal("2000.00"));
                add("usuarioCriacao", "Funcionario A");
                add("usuarioAlteracao", "Funcionario B");
                add("dataCriacao", DATA_CRIACAO);
                add("dataAlteracao", DATA_ALTERACAO);
            }
        });
        of(Cliente.class).addTemplate("valid", new Rule() {
            {
                add("cpf", "73738802070");
                add("nome", "Cliente A");
                add("email", "cliente@gmail.com");
                add("telefones", has(2).of(Telefone.class, "valid"));
                add("usuarioCriacao", "cliente A");
                add("usuarioAlteracao", "cliente B");
                add("dataCriacao", DATA_CRIACAO);
                add("dataAlteracao", DATA_ALTERACAO);
            }
        });
        of(Telefone.class).addTemplate("valid", new Rule() {
            {
                add("ddd", "11");
                add("numero", "967976463");
                add("ddi", "55");
                add("telefoneType", CELULAR);
                add("usuarioCriacao", "Pessoa A");
                add("usuarioAlteracao", "Pessoa B");
                add("dataCriacao", DATA_CRIACAO);
                add("dataAlteracao", DATA_ALTERACAO);
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
                add("usuarioCriacao", "Pessoa A");
                add("usuarioAlteracao", "Pessoa B");
                add("dataCriacao", DATA_CRIACAO);
                add("dataAlteracao", DATA_ALTERACAO);
            }
        });
    }
}
