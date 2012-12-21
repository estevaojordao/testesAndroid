package dao;

public class BensServicosDao {  
    private static String table_name = "BensServicos";  
    private static Context ctxt;  
    private static String[] columns = { "id_bensservicos", "codigo_despesa",  
            "nome_bensservicos", "valor_benservicos", "data_bensservicos" };  
  
    public BensServicosDao(Context ctxt) {  
        this.ctxt = ctxt;  
    }  
  
    // método que realiza inserção no banco  
    public boolean insert(BensServicosVO vo) {  
        SQLiteDatabase db = new Db(ctxt).getWritableDatabase();  
        ContentValues ctv = new ContentValues();  
          
        ctv.put("nome_bensservicos", vo.getNome_bensservicos());  
        ctv.put("valor_benservicos", vo.getValor_benservicos());  
        ctv.put("data_bensservicos", vo.getData_bensservicos().toString());  
  
        return db.insert(table_name, null, ctv) > 0;  
    }  
  
    // método que realiza exclusão no banco  
    public boolean delete(BensServicosVO vo) {  
        SQLiteDatabase db = new Db(ctxt).getWritableDatabase();  
        return (db.delete(table_name, "id_bensservicos=?", new String[] { vo  
                .getId_bensservicos().toString() }) > 0);  
    }  
  
    // método que realiza alteração no banco  
    public boolean update(BensServicosVO vo) {  
        SQLiteDatabase db = new Db(ctxt).getWritableDatabase();  
        ContentValues ctv = new ContentValues();  
        ctv.put("nome_bensservicos", vo.getNome_bensservicos());  
        ctv.put("valor_benservicos", vo.getValor_benservicos());  
        ctv.put("data_bensservicos", vo.getData_bensservicos().toString());  
  
        return db.update(table_name, ctv, "id_bensservicos?", new String[] { vo  
                .getId_bensservicos().toString() }) > 0;  
    }  
  
    // edição de lista  
    public BensServicosVO getById(Integer ID) {  
        SQLiteDatabase db = new Db(ctxt).getReadableDatabase();  
  
        Cursor rs = db.query(table_name, columns, "id_bensservicos=?",  
                new String[] { ID.toString() }, null, null, null, null);  
  
        BensServicosVO vo = null;  
        if (rs.moveToFirst()) {  
            vo = new BensServicosVO();  
            vo.setId_bensservicos(rs.getInt(rs  
                    .getColumnIndex("id_bensservicos")));  
            vo.setCodigo_despesa(rs.getInt(rs.getColumnIndex("codigo_despesa")));  
            vo.setNome_bensservicos(rs.getString(rs  
                    .getColumnIndex("nome_bensservicos")));  
            vo.setValor_benservicos(rs.getFloat(rs  
                    .getColumnIndex("valor_benservicos")));  
            vo.setData_bensservicos(rs.getString(rs  
                    .getColumnIndex("data_bensservicos")));  
        }  
        return vo;  
    }  
  
    // trabalhar com listagem  
    public List<BensServicosVO> getAll() {  
        SQLiteDatabase db = new Db(ctxt).getReadableDatabase();  
  
        Cursor rs = db.rawQuery("SELECT * FROM BensServicos", null);  
        List<BensServicosVO> lista = new ArrayList<BensServicosVO>();  
  
        while (rs.moveToNext()) {  
            BensServicosVO vo = new BensServicosVO(rs.getInt(0), rs.getInt(1),  
                    rs.getString(2), rs.getFloat(3), rs.getString(4));  
            lista.add(vo);  
        }  
  
        return lista;  
    }  
  
}  
