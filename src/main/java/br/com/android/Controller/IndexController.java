package br.com.android.Controller;

import br.com.android.DAO.CategoriaDAO;
import br.com.android.DAO.OrigemDAO;
import br.com.android.DAO.ReceitaDAO;
import br.com.android.Model.Receita;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import static br.com.caelum.vraptor.view.Results.xml;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;

@Controller
public class IndexController {

    private ReceitaDAO receitaDAO;
    private CategoriaDAO categoriaDAO;
    private OrigemDAO origemDAO;
    private final Result result;

    /**
     * @deprecated CDI eyes only
     */
    protected IndexController() {
        this(null, null, null, null);
    }

    @Inject
    public IndexController(ReceitaDAO receitaDAO, CategoriaDAO categoriaDAO, OrigemDAO origemDAO, Result result) {
        this.receitaDAO = receitaDAO;
        this.categoriaDAO = categoriaDAO;
        this.origemDAO = origemDAO;
        this.result = result;
    }

    @Path("/")
    public void index() {
        result.use(xml()).from(receitaDAO.listAll()).recursive().serialize();
    }

    @Path("/receitas")
    public void receitas() {
        Random random = new Random();
        List<Receita> listaReceitas = new ArrayList<>();
        listaReceitas = receitaDAO.listAll();
        
        int nextInt = random.nextInt(receitaDAO.listAll().size());
        
        result.use(xml()).from(listaReceitas.get(nextInt)).recursive().serialize();
    }

    @Path("/categoria")
    public void categoria() {
        result.use(xml()).from(categoriaDAO.listAll()).serialize();
    }

    @Path("/origem")
    public void origem() {
        result.use(xml()).from(origemDAO.listAll()).serialize();
    }

    @Path("/procura/{titulo}/{origem}/{categoria}")
    public void procura(String titulo, String origem, String categoria) {
        result.use(xml()).from(receitaDAO.pesquisaPorNome(titulo, origem, categoria)).recursive().serialize();
    }
}
