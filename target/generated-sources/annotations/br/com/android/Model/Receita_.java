package br.com.android.Model;

import br.com.android.Model.Categoria;
import br.com.android.Model.Origem;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-21T22:12:44")
@StaticMetamodel(Receita.class)
public class Receita_ { 

    public static volatile SingularAttribute<Receita, String> modoPreparo;
    public static volatile SingularAttribute<Receita, String> ingredientes;
    public static volatile SingularAttribute<Receita, Long> idReceita;
    public static volatile SingularAttribute<Receita, Categoria> categoria;
    public static volatile SingularAttribute<Receita, Origem> origem;
    public static volatile SingularAttribute<Receita, String> titulo;
    public static volatile SingularAttribute<Receita, String> valorEstimado;
    public static volatile SingularAttribute<Receita, String> porcao;

}