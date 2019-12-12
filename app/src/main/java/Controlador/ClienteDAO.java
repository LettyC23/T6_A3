package Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Modelo.Cliente;

public class ClienteDAO extends SQLiteOpenHelper {

    private static final int VERSION_BD = 1;
    private static final String NOMBRE_BD = "SistFacturacion";
    private static final String TABLA_CLIENTES = "Clientes";
    private static final String CAMPO_ID_CLIENTE = "id_Cliente";
    private static final String CAMPO_NOMBRE = "Nombre";
    private static final String CAMPO_PRIMERAP = "Primer_AP";
    private static final String CAMPO_SEGUNDOAP = "Segundo_Ap";
    private static final String CAMPO_DIRECCION = "Direccion";
    private static final String CAMPO_FECHANAC = "FechaNac";
    private static final String CAMPO_TELEFONO = "Telefono";
    private static final String CAMPO_EMAIL = "Email";

    private static final String CREAR_TABLA_CLIENTES = "CREATE TABLE "+TABLA_CLIENTES+"("+CAMPO_ID_CLIENTE+
            " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PRIMERAP+" TEXT, "+CAMPO_SEGUNDOAP+" TEXT, "+CAMPO_DIRECCION+" TEXT, "
            +CAMPO_FECHANAC+" TEXT, "+CAMPO_TELEFONO+" TEXT," +CAMPO_EMAIL+" TEXT)";



    private static final String TABLA_MODO_PAGO = "Modo_Pago";
    private static final String CAMPO_ID_PAGO = "id_Pago";
    private static final String CAMPO_NOMBREPAGO = "id_Cliente";

    private static final String CREAR_TABLA_MODO_PAGO = "CREATE TABLE "+TABLA_MODO_PAGO+"("+CAMPO_ID_PAGO+
            " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "+CAMPO_NOMBREPAGO+" TEXT)";


    private static final String TABLA_FACTURA = "Factura";
    private static final String CAMPO_NUMFACT = "NumFactura";
    private static final String CAMPO_FECHA = "Fecha";
    private static final String CAMPO_ID_PAGOFK = "id_Pago";
    private static final String CAMPO_ID_CLIENTEFK = "id_Cliente";

    private static final String CREAR_TABLA_FACTURA = "CREATE TABLE "+TABLA_FACTURA+"("+CAMPO_NUMFACT+
            " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "+CAMPO_FECHA+" TEXT, "+CAMPO_ID_PAGOFK+" INTEGER, "
            +CAMPO_ID_CLIENTEFK+" INTEGER)";


    private static final String TABLA_CATEGORIA_PRODUCTO = "Categoria_Producto";
    private static final String CAMPO_ID_CATEGORIA = "id_Categoria";
    private static final String CAMPO_NOMBRECAT = "Nombre";
    private static final String CAMPO_DESCRIPCIONCAT = "Descripcion";

    private static final String CREAR_TABLA_CATEGORIA_PRODUCTO = "CREATE TABLE "+TABLA_CATEGORIA_PRODUCTO+"("+CAMPO_ID_CATEGORIA+
            " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "+CAMPO_NOMBRECAT+" TEXT, "+CAMPO_DIRECCION+" TEXT)";


    private static final String TABLA_PRODUCTOS = "Productos";
    private static final String CAMPO_ID_PRODUCTOS = "id_Productos";
    private static final String CAMPO_NOMBREPRODUCTO = "NombreProducto";
    private static final String CAMPO_PRECIO = "Precio";
    private static final String CAMPO_STOCK = "Stock";
    private static final String CAMPO_ID_CATEGORIAFK = "id_Categoria";

    private static final String CREAR_TABLA_PRODUCTOS = "CREATE TABLE "+TABLA_PRODUCTOS+"("+CAMPO_ID_PRODUCTOS+
            " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "+CAMPO_NOMBREPRODUCTO+" TEXT, "+CAMPO_PRECIO+" INTEGER, "
            +CAMPO_STOCK+" INTEGER, "+CAMPO_ID_CATEGORIAFK+" INTEGER)";



    private static final String TABLA_VENTAS = "Ventas";
    private static final String CAMPO_ID_VENTA = "id_Venta";
    private static final String CAMPO_NUMFACTURAFK = "NumFactura";
    private static final String CAMPO_ID_PRODUCTO_FK = "id_Producto";
    private static final String CAMPO_CANTIDAD = "Cantidad";
    private static final String CAMPO_PRECIO_VENTA = "Precio";
    private static final String CAMPO_TOTAL = "TOTAL";

    private static final String CREAR_TABLA_VENTAS = "CREATE TABLE "+TABLA_VENTAS+"("+CAMPO_ID_VENTA+
            " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "+CAMPO_NUMFACTURAFK+" INTEGER, "+CAMPO_ID_PRODUCTO_FK+
            " INTEGER, "+CAMPO_CANTIDAD+" INTEGER, "+CAMPO_PRECIO_VENTA+" INTEGER, "
            +CAMPO_TOTAL+" INTEGER)";

    public ClienteDAO(@Nullable Context context) {
        super(context, NOMBRE_BD, null , VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CLIENTES);
        db.execSQL(CREAR_TABLA_MODO_PAGO);
        db.execSQL(CREAR_TABLA_FACTURA);
        db.execSQL(CREAR_TABLA_CATEGORIA_PRODUCTO);
        db.execSQL(CREAR_TABLA_PRODUCTOS);
        db.execSQL(CREAR_TABLA_VENTAS);
        //db.execSQL("CREATE TABLE Clientes (id_Empleado Integer primary key not null, Nombre text, primerAp text , " +
          //      "segundoAp text , direccion text, fechaNac text, telefono text, email text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, int i, int i1) {

    }
    public boolean agregarCliente(Cliente c) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Meter datos en el ojeto
        ContentValues cv = new ContentValues();
        //(campo, dato)
        cv.put(CAMPO_NOMBRE, c.getNombre());
        cv.put(CAMPO_PRIMERAP, c.getPrimerAp());
        cv.put(CAMPO_SEGUNDOAP, c.getSegundoAp());
        cv.put(CAMPO_DIRECCION, c.getDireccion());
        cv.put(CAMPO_FECHANAC, c.getFechaNac());
        cv.put(CAMPO_TELEFONO, c.getTelefono());
        cv.put(CAMPO_EMAIL, c.getEmail());

        long res = db.insert(TABLA_CLIENTES, null, cv);

        //Ternario

        return (res==-1) ? false:true;

    }

    public ArrayList<Cliente> obtenerTodosLosClientes(String filtro) {

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLA_CLIENTES+" WHERE nombre=?" ;

        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(filtro)});
        //Si hay o no registros
        if (cursor.moveToFirst()) {
            do {
                listaClientes.add(new Cliente(cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),
                        cursor.getString(4),cursor.getString(5),
                        cursor.getString(6),cursor.getString(7)));


            }while(cursor.moveToNext()); //poder moverse al siguiente
        }
        return listaClientes;
    }
    public boolean Modificar(String nc, Cliente c){
        //ClienteDAO em = new ClienteDAO(this, "Fact", null,1);
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues cv = new ContentValues();
        cv.put("Nombre", c.getNombre());
        cv.put("primer_Ap", c.getPrimerAp());
        cv.put("segundo_Ap", c.getSegundoAp());
        cv.put("direccion", c.getDireccion());
        cv.put("fechaNac", c.getFechaNac());
        cv.put("Telefono", c.getTelefono());
        cv.put("email", c.getEmail());


            int cantidad = db.update(TABLA_CLIENTES, cv, "nombre = ?", new String[]{String.valueOf(nc)});
            db.close();

        return (cantidad==-1) ? false:true;
    }


    public boolean Eliminar(String nc) {
        SQLiteDatabase db = this.getWritableDatabase();




            int cantidad = db.delete(TABLA_CLIENTES, "nombre= ?", new String[]{String.valueOf(nc)});
            db.close();

            //et_nombre.setText("");

        return (cantidad==-1) ? false:true;


    }
}
