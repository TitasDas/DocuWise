package com.example.sampleapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SqliteAdapter {

    myDbHelper myhelper;

    public SqliteAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(Integer mw, String category,
                           String  target, String  rts,
                           String  platform, Double  range_lod,
                           Double  max_range, String  selectivity,
                           Integer  response, String  durability, String  sample)
    {

        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.MW, mw);
        contentValues.put(myDbHelper.CATEGORY, category);
        contentValues.put(myDbHelper.TARGET, target);
        contentValues.put(myDbHelper.RTS, rts);
        contentValues.put(myDbHelper.PLATFORM, platform);
        contentValues.put(myDbHelper.RANGE_LOD, range_lod);
        contentValues.put(myDbHelper.MAX_RANGE, max_range);
        contentValues.put(myDbHelper.SELECTIVITY, selectivity);
        contentValues.put(myDbHelper.RESPONSE, response);
        contentValues.put(myDbHelper.DURABILTY, durability);
        contentValues.put(myDbHelper.SAMPLE, sample);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public long insertBulkData()
    {
        insertData(1, "small molecule", "H+", "H+ ionophore (liquid)", "glass capillary", 0.013,  0.0001,  "excellent (K+, Na+, Ca2+, Mg2+)",  2, "High", "hydroponics, irrigation water, cell culture media");
        insertData(1, "small molecule", "H+", "anthocyanin/nanocellulose", "paper filter", 0.015,  0.01,  "excellent",  2, "high", "irrigation water, lake water, buffer");
        insertData(1, "small molecule", "H+", "anthocyanin/nanocellulose", "paper filter", 0.015,  0.01,  "excellent",  2, "high", "irrigation water, lake water, buffer");
        insertData(18, "small molecule", "Ammonium", "NH4+ ionophore (liquid)", "glass capillary", 0.000000005,  0.1,  "excellent",  5, "medium", "wastewater, plant root media, Hoagland solution");
        insertData(18, "small molecule", "Ammonium", "NH4+ ionophore (solid)", "LSG ", 0.000028,  0.5,  "excellent",  2, "medium", "wastewater, plant root media, Hoagland solution");
        insertData(18, "small molecule", "Ammonium", "NH4+ ionophore (solid)", "LSG ", 0.000028,  0.5,  "excellent",  2, "medium", "wastewater, plant root media, Hoagland solution");
        insertData(30, "small molecule", "N/O radicals", "nanoplatinum/nanoceria", "Pt electrode", 0.00000001,  0.000003,  "medium",  1, "medium", "ocean water, buffer, LSB media");
        insertData(32, "small molecule", "DO", "Pt porphyrin-nTiO2", "fiber optic", 0.000001,  0.000005,  "excellent, temp sens",  1, "High", "hydroponic media, lake water, ");;
        insertData(32, "small molecule", "DO", "Pt porphyrin", "96 well", 0.000001,  0.000005,  "excellent, temp sens",  45, "low", "hydroponic media, lake water, ");
        insertData(32, "small molecule", "DO", "Pt porphyrin", "glass vial ", 0.000001,  0.000005,  "excellent, temp sens",  45, "low", "hydroponic media, lake water, ");
        insertData(34, "small molecule", "H2O2", "fractal nPt", "Pt electrode", 0.000000005,  0.00005,  "excellent",  1, "high", "ocean water, buffer, tissue culture media");
        insertData(34, "small molecule", "H2O2", "nPd-CNT", "Si/PAA", 0.09,  0.0,  "medium",  5, "high", "buffer");
        insertData(34, "small molecule", "H2O2", "nPt", "inkjet printed graphene", 0.0000005,  1.0,  "medium",  5, "high", "buffer");
        insertData(34, "small molecule", "H2O2", "IPG-PET", "PET", 0.0000001,  0.00055,  "medium",  5, "medium", "buffer");
        insertData(34, "small molecule", "H2O2", "nPt", "CNT electrode", 0.00000003,  0.0005,  "medium",  20, "high", "buffer");
        insertData(34, "small molecule", "H2O2", "fractal nPt", "Pt electrode", 0.000000005,  0.00005,  "excellent",  1, "high", "ocean water, buffer, tissue culture media");
        insertData(34, "small molecule", "H2O2", "copper (II) chlorophyllin trisodium-PPY", "SPE", 0.0000003,  0.001,  "high",  5, "0", "buffer");
        insertData(39, "small molecule", "K+", "K+ ionophore (liquid)", "glass capillary", 0.000001,  0.25,  "excellent",  2, "low", "wastewater, plant root media, Hoagland solution");
        insertData(39, "small molecule", "K+", "IPG-K+ ionophre", "Si ", 0.00001,  0.1,  "medium (Na, Mg, Ca)",  10, "high", "buffer, artificial eccrine perspiration");
        insertData(41, "small molecule", "Ca2+", "Ca2+ ionophore (liquid)", "glass capillary", 0.000001,  0.5,  "excellent",  1, "low", "Hoaglands media, bone/osteoblast matrix");
        insertData(58, "small molecule", "acetone", "chemosensory proteins-nPt ", "Pt electrode", 0.000005,  0.00001,  "high",  10, "low", "buffer");
        insertData(62, "small molecule", "Nitrate", "NO3- ionophore (liquid)", "glass capillary", 0.000001,  0.2,  "excellent",  2, "medium", "wastewater, plant root media, Hoagland solution");
        insertData(62, "small molecule", "Nitrate", "NO3- ionophore (solid)", "LSG ", 0.00002,  0.15,  "excellent",  2, "medium", "wastewater, plant root media, Hoagland solution");
        insertData(108, "small molecule", "Ag+", "Ag+ ionophore (liquid)", "glass capillary", 0.000001,  0.05,  "excellent",  2, "high", "wound dressing, daphnia magna embryos");
        insertData(111, "small molecule", "histamine", "diamine oxidase-nCu", "LSG", 0.000063,  0.001,  "excellent",  2, "medium", "fermented fish, buffer, tea");
        insertData(147, "small molecule", "Glutamate", "CNT/nPt/GlOx", "Pt electrode", 0.000001,  0.001,  "excellent",  2, "low", "INS1 tissue culture");
        insertData(147, "small molecule", "Glutamate", "CNT/nPt/GlOx", "Si biochip", 0.000001,  0.5,  "excellent",  2, "low", "INS1 tissue culture");
        insertData(154, "small molecule", "catecholamines", "nPt", "LSG", 0.0000005,  0.003,  "excellent",  2, "high", "ocean water, buffer, tissue culture media, breast milk");
        insertData(154, "small molecule", "catecholamines", "graphene anchored nCuO", "LSG", 0.0000003,  0.003,  "high",  2, "medium", "buffer, lake water");
        insertData(176, "small molecule", "indole acetic acid", "fractal nPt", "Pt/Ir microwire", 0.000001,  0.001,  "high",  1, "high", "root growth media");
        insertData(181, "small molecule", "Glucose", "nPt/GOx", "graphene paper", 0.00000008,  0.001,  "excellent",  2, "medium", "buffer");
        insertData(181, "small molecule", "Glucose", "nPt/GOx", "Pt/Ir microwire", 0.0000001,  0.000005,  "excellent",  1, "medium", "blood, tears, buffer, growth media, in vivo tissues (mouse)");
        insertData(181, "small molecule", "Glucose", "nPt/nCe/GOx", "Pt electrode", 0.0000001,  0.000003,  "excellent",  1, "medium", "buffer");
        insertData(181, "small molecule", "Glucose", "nPd-CNT", "Si/PAA", 0.00001,  50.0,  "excellent",  5, "low", "buffer");
        insertData(181, "small molecule", "Glucose", "nPt-rGO", "Graphene petal-GOx", 0.0000003,  50.0,  "excellent",  10, "high", "buffer");
        insertData(181, "small molecule", "Glucose", "aptamer-nPt-rGO", "Pt/Ir electrode", 0.000001,  7.0,  "medium",  5, "low", "buffer ");
        insertData(181, "small molecule", "Glucose", "nAu-Alkanethiol", "Si/PAA", 0.001,  21.0,  "high",  5, "medium", "buffer");
        insertData(181, "small molecule", "Glucose", "nPt-CNT", "Si/PAA", 0.00000038,  10.0,  "high",  8, "medium", "buffer");
        insertData(181, "small molecule", "Glucose", "nPt-GOx", "Si/PAA", 0.0003,  15.0,  "high",  5, "high", "buffer");
        insertData(181, "small molecule", "H2O2", "CNT-Gox-PEDOT", "vertically aligned CNT", 0.0000001,  0.0002,  "medium",  1200, "", "");
        insertData(201, "small molecule", "ionic mercury", "graphene anchored nCuO", "LSG", 0.000000099,  0.0000125,  "excellent",  180, "medium", "buffer, lake water");
        insertData(256, "small molecule", "imidacloprid", "rGO-nPt", "Pt electrode", 0.00056,  0.000195,  "medium",  3, "medium", "honey, wax, lake water, buffer");
        insertData(275, "small molecule", "paraoxon", "IPG-nPt-phosphotriesterase", "Si", 0.000000003,  0.000001,  "medium",  5, "medium", "buffer");
        insertData(275, "small molecule", "paraoxon", "phosphotriesterase", "nAu", 0.0, 0.0 ,  "",  0, "", "");
        insertData(507, "small molecule", "ATP", "RGO-nPt-hydrogel", "Pt electrode", 0.000002,  0.00001,  "excellent",  2, "low", "plant growth media, root tissue, biofilm on pipe");
        insertData(507, "small molecule", "ATP", "aptamer-nPt-rGO", "Pt/Ir electrode", 0.000002,  510.0,  "medium",  5, "low", "buffer");
        insertData(17000, "small protein", "MBF1", "TBP-nPt", "Pt electrode", 0.0, 0.0,  "excellent",  300, "low", "buffer");
        insertData(17146, "small protein", "interferon gamma", "aptamer-nPt-rGO", "Au IDE", 2.2,  1.1E-10,  "",  2100, "low", "buffer");
        insertData(17146, "small protein", "interferon gamma", "aptamer-nPt-rGO", "Au IDE", 2.2,  110.0,  "medium",  2100, "low", "buffer");
        insertData(32500, "small molecule", "superoxide dismutase", "nAu-Ppy-Ab", "SP carbon electrode", 5.3,  5.0,  "high (myoglobin, cytochrome c)",  1200, "low", "human epidermal keratinocytes");
        insertData(100000, "small protein", "CIP2A", "CNT-Ab", "SPE-IDE", 2.4,  1E-10,  "high",  2100, "medium", "saliva supernatant");
        insertData(0, "bacteria", "E. coli (generic)", "IgG + PNIPAAM", "Pt electrode", 4.0,  100000.0,  "excellent. ",  1000, "medium", "buffer, real food");
        insertData(0, "bacteria", "E. coli (generic)", "lectin + PNIPAAM", "Pt electrode", 5.0,  100000.0,  "medium",  1000, "medium", "buffer, real food");
        insertData(0, "bacteria", "E. coli (generic)", "aptamer-nPt", "LSG/nanocopper", 5.0,  100000.0,  "excellent",  1000, "medium", "buffer, veggie juice");
        insertData(0, "bacteria", "E. coli O157:H7", "aptamer-nPt", "graphene paper", 9.0,  100000.0,"",0,"medium", "buffer, veggie juice");
        insertData(0, "bacteria", "Salmonella", "aptamer-nAu", "Au electrode", 89.0,  100000.0,  "excellent",  1000, "medium", "buffer, real food");
        insertData(0, "bacteria", "Campylobacter", "aptamer-nAu", "Au electode", 10.0,  100000.0,  "medium",  1500, "medium", "buffer, veggie juice");
        insertData(0, "bacteria", "Listeria", "aptamer + CHI", "Pt electrode", 5.0,  100000.0,  "excellent",  720, "medium", "buffer, real food");
        insertData(0, "bacteria", "Listeria", "IgG + CHI", "Pt electrode", 5.0,  100000.0,  "excellent",  720, "medium", "buffer, real food");
        insertData(0, "bacteria", "E. coli (strain?)", "lectin (ConA)", "Pt foil", 10.0,  0.0,  "low",  0, "low", "apple juice, seawater, drinking water");

        /*
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.MW, 1);
        contentValues.put(myDbHelper.CATEGORY, "small molecule");
        dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        contentValues = new ContentValues();
        contentValues.put(myDbHelper.MW, 2);
        contentValues.put(myDbHelper.CATEGORY, "small protein");
        dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        contentValues = new ContentValues();
        contentValues.put(myDbHelper.MW, 3);
        contentValues.put(myDbHelper.CATEGORY, "big molecule");
        dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        contentValues = new ContentValues();
        contentValues.put(myDbHelper.MW, 4);
        contentValues.put(myDbHelper.CATEGORY, "bacteria");
        dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        */
        return 0;

    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,
                myDbHelper.MW,
                myDbHelper.CATEGORY,
                myDbHelper.TARGET,
                myDbHelper.RTS,
                myDbHelper.PLATFORM,
                myDbHelper.RANGE_LOD,
                myDbHelper.MAX_RANGE,
                myDbHelper.SELECTIVITY,
                myDbHelper.RESPONSE,
                myDbHelper.DURABILTY,
                myDbHelper.SAMPLE};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            Integer mw =cursor.getInt(cursor.getColumnIndex(myDbHelper.MW));
            String  category =cursor.getString(cursor.getColumnIndex(myDbHelper.CATEGORY));
            String  target =cursor.getString(cursor.getColumnIndex(myDbHelper.TARGET));
            String  rts =cursor.getString(cursor.getColumnIndex(myDbHelper.RTS));
            String  platform =cursor.getString(cursor.getColumnIndex(myDbHelper.PLATFORM));
            Double  range_lod =cursor.getDouble(cursor.getColumnIndex(myDbHelper.RANGE_LOD));
            Double  max_range =cursor.getDouble(cursor.getColumnIndex(myDbHelper.MAX_RANGE));
            String  selectivity =cursor.getString(cursor.getColumnIndex(myDbHelper.SELECTIVITY));
            Integer  response =cursor.getInt(cursor.getColumnIndex(myDbHelper.RESPONSE));
            String  durability =cursor.getString(cursor.getColumnIndex(myDbHelper.DURABILTY));
            String  sample =cursor.getString(cursor.getColumnIndex(myDbHelper.SAMPLE));
            buffer.append(cid+ "   " + mw + "   " + category + "   " + target + "   " + rts + "   " + platform +
                    range_lod + "   " + max_range + "   " + selectivity + "   " + response + "   " +
                    durability + "   " + sample + " \n");
        }
        return buffer.toString();
    }



    ArrayList<String> getAnswer() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Cursor cursor;
            SQLiteDatabase db = myhelper.getReadableDatabase();

            /*
            1. What is the LOD score ofr ionic mercur.y
            2. Can I use gr
            3. Is the ammonium ioosphere liquid or solid?
            4. What type of reconition tool to you haev tohhand for detecting imidaclopid?
            5. What is the

            5.What is the
             */




            // What is the res response time for superoxide dismustase?

             //responnse time for sup..

            //E coli?
            //aphene paper to detect
            //y






            cursor = db.rawQuery("SELECT * FROM student_details", null);
            list.clear();
            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    do {
                        list.add(cursor.getString(cursor.getColumnIndex("student_name")));
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
        } catch (Exception e) {
            Log.v("Exception", e.toString());
        }
        return list;
    }





    public  int delete(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        int count =db.delete(myDbHelper.TABLE_NAME ,myDbHelper.MW+" = ?",whereArgs);
        return  count;
    }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.MW,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.MW+" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 2;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String MW = "MW";    //Column II
        private static final String CATEGORY = "Category";    // Column III
        private static final String TARGET = "Target";    // Column IV
        private static final String RTS = "RTS";    // Column V
        private static final String PLATFORM = "Platform";    // Column VI
        private static final String RANGE_LOD = "Range_LOD";    // Column VII
        private static final String MAX_RANGE = "Max_Range";    // Column VIII
        private static final String SELECTIVITY = "Selectivity";    // Column IX
        private static final String RESPONSE = "ResponseTime";    // Column X
        private static final String DURABILTY = "Durabilty";    // Column XI
        private static final String SAMPLE = "Sample";    // Column XII
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+MW+" TINYINT ," +
                ""+CATEGORY+" VARCHAR(100) ," +
                ""+TARGET+" VARCHAR(100) ," +
                ""+RTS+" VARCHAR(100) ," +
                ""+PLATFORM+" VARCHAR(100) ," +
                ""+RANGE_LOD+" DOUBLE ," +
                ""+MAX_RANGE+" DOUBLE ," +
                ""+SELECTIVITY+" VARCHAR(100) ," +
                ""+RESPONSE+" INTEGER ," +
                ""+DURABILTY+" VARCHAR(100) ," +
                ""+SAMPLE+" VARCHAR(100));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                // Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                // Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                // Message.message(context,""+e);
            }
        }
    }
}
