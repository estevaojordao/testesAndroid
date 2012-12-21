package dao;

public class BensServicos extends Activity {  
	  
    private static final String[] opcoes = {"Pretação do carro","IPVA","Seguro do carro","Plano de saúde/odontológico","Faculdade e colégio","Plano de previdência","Outras Despesas"};  
      
    static final int DATE_DIALOG_ID = 0;  
    private Button btnIncluirBensServicos;  
    private Button btnVoltarBensServicos;  
    private DatePicker dtpDataBensServicos;  
    private EditText edtxtValorBensServicos;  
    private Spinner spnBensServicos;  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.bensservicos);  
          
        ArrayAdapter <String> oopcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcoes);  
        btnIncluirBensServicos = (Button) findViewById(R.id.btnIncluirBensServicos);  
        btnVoltarBensServicos = (Button) findViewById(R.id.btnVoltarBensServicos);  
        dtpDataBensServicos = (DatePicker)findViewById(R.id.dtpDataBensServicos);  
        edtxtValorBensServicos = (EditText)findViewById(R.id.edtxtValorBensServicos);  
        spnBensServicos = (Spinner)findViewById(R.id.spnBensServicos);  
          
        spnBensServicos.setAdapter(oopcoes);  
  
        btnIncluirBensServicos.setOnClickListener(new View.OnClickListener() {  
  
            public void onClick(View v) {  
          
                BensServicosVO vo = new BensServicosVO();  
                vo.setNome_bensservicos(spnBensServicos.getAdapter().toString());  
                vo.setValor_benservicos(Float.valueOf(edtxtValorBensServicos.getText().toString()));  
                int dia = dtpDataBensServicos.getDayOfMonth();  
                int mes = dtpDataBensServicos.getMonth();  
                int ano = dtpDataBensServicos.getYear();  
                vo.setData_bensservicos(String.valueOf(ano)+"-"+String.valueOf(mes+1) +"-"+String.valueOf(dia));  
                  
                BensServicosDao dao = new BensServicosDao(getBaseContext());  
                if(dao.insert(vo)){  
                    Toast.makeText(getBaseContext(), "Você incluiu despesa com sucesso", Toast.LENGTH_SHORT).show();  
                    finish();  
                }  
                //startActivity(new Intent(getBaseContext(), Principal.class));  
  
            }  
        });  
  
        btnVoltarBensServicos.setOnClickListener(new View.OnClickListener() {  
  
            public void onClick(View v) {  
                startActivity(new Intent(getBaseContext(), Principal.class));  
  
            }  
        });  
      
          
    }  
      
              
}  
