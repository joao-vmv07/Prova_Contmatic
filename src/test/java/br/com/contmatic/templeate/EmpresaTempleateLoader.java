package br.com.contmatic.templeate;

import java.util.HashSet;
import java.util.Set;

import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTempleateLoader implements TemplateLoader {

    @Override
    public void load() {
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(new Endereco("04852505", 83));
        Set<Telefone> telefones = new HashSet<>();
        telefones.add(new Telefone("55", "11", "967976463"));
        telefones.add(new Telefone("55", "11", "968984543"));
        
        Fixture.of(Empresa.class).addTemplate("valid", new Rule() {{
            add("cnpj", "17081431000122");
            add("razaoSocial", "VIVO LTDA");
            add("nomeFantasia", "VIVO");
            add("telefones", telefones);
            add("enderecos", enderecos);
        }});
        
        Fixture.of(Empresa.class).addTemplate("random", new Rule() {{
            add("cnpj", cnpj());
            add("razaoSocial", uniqueRandom("Santander S.A", "Unibanco ITAU", "Bradesco S.A"));
            add("nomeFantasia",uniqueRandom("Santander", "ITAU", "Bradesco"));
            add("telefones", telefones);
            add("enderecos", enderecos);
        }});
        
    }
  

}
