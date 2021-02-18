package org.lila_systems.mypet.gui;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import org.lila_systems.mypet.model.Empleado;
import org.lila_systems.mypet.model.Mascota;
import org.lila_systems.mypet.model.Mercancia;
import org.lila_systems.mypet.model.Persona;
import org.lila_systems.mypet.model.Producto;
import org.lila_systems.mypet.model.Proveedor;

public class PrincipalController implements Initializable {

    @FXML
    private MenuBar idMenuBar;

    @FXML
    private MenuItem mnitmCerrarSesion;

    //---------------MERCANCIA---------------
    @FXML
    private TextField txtIdProductoM;

    @FXML
    private TextField txtIdMercanciaM;

    @FXML
    private TextField txtCodigoBarrasM;

    @FXML
    private TextField txtNombreM;

    @FXML
    private TextField txtMarcaM;

    @FXML
    private Button btnGuardarM;

    @FXML
    private Button btnLimpiarM;

    @FXML
    private TextField txtModeloM;

    @FXML
    private TextField txtExistenciasM;

    @FXML
    private TextArea txtDescripcionM;

    @FXML
    private TextField txtPrecioCompraM;

    @FXML
    private TextField txtPrecioVentaM;

    @FXML
    private CheckBox cbxEstatusM;

    @FXML
    private TableView<Mercancia> idTableM;

    @FXML
    private TableColumn<Mercancia, Integer> colIdMercanciaM;

    @FXML
    private TableColumn<Mercancia, Producto> colIdProductoM;

    @FXML
    private TableColumn<Mercancia, Producto> colNombreM;

    @FXML
    private TableColumn<Mercancia, Producto> colExistenciasM;

    @FXML
    private TableColumn<Mercancia, Producto> colPrecioCompraM;

    @FXML
    private TableColumn<Mercancia, Producto> colPrecioVentaM;

    @FXML
    private TableColumn<Mercancia, Producto> colEstatusM;

    @FXML
    private TableColumn<Mercancia, String> colCodigoBarrasM;

    @FXML
    private TableColumn<Mercancia, String> colMarcaM;

    @FXML
    private TableColumn<Mercancia, String> colModeloM;

    @FXML
    private TableColumn<Mercancia, String> colDescripcionM;

    //---------------EMPLEADO---------------
    @FXML
    private TextField txtIdPersonaE;

    @FXML
    private TextField txtIdEmpleadoE;

    @FXML
    private TextField txtNombreE;

    @FXML
    private TextField txtApellidoPaternoE;

    @FXML
    private TextField txtApellidoMaternoE;

    @FXML
    private TextField txtFechaNacimientoE;

    @FXML
    private TextField txtTel1E;

    @FXML
    private TextField txtTel2E;

    @FXML
    private TextField txtCalleE;

    @FXML
    private TextField txtNoE;

    @FXML
    private TextField txtColoniaE;

    @FXML
    private TextField txtCPE;

    @FXML
    private TextField txtCiudadE;

    @FXML
    private TextField txtEstadoE;

    @FXML
    private TextField txtCorreoE;

    @FXML
    private PasswordField txtContraseniaE;

    @FXML
    private CheckBox cbxEstatusE;

    @FXML
    private Button btnGuardarE;

    @FXML
    private Button btnLimpiarE;

    @FXML
    private TableView<Empleado> idTableE;

    @FXML
    private TableColumn<Empleado, Persona> colIdPersonaE;

    @FXML
    private TableColumn<Empleado, Integer> colIdEmpleadoE;

    @FXML
    private TableColumn<Empleado, Persona> colNombreE;

    @FXML
    private TableColumn<Empleado, Persona> colApaternoE;

    @FXML
    private TableColumn<Empleado, Persona> colAmaternoE;

    @FXML
    private TableColumn<Empleado, Persona> colFechaNacE;

    @FXML
    private TableColumn<Empleado, Persona> colTel1E;

    @FXML
    private TableColumn<Empleado, Persona> colTel2E;

    @FXML
    private TableColumn<Empleado, Persona> colCalleE;

    @FXML
    private TableColumn<Empleado, Persona> colNoE;

    @FXML
    private TableColumn<Empleado, Persona> colColoniaE;

    @FXML
    private TableColumn<Empleado, Persona> colCPE;

    @FXML
    private TableColumn<Empleado, Persona> colCiudadE;

    @FXML
    private TableColumn<Empleado, Persona> colEstadoE;

    @FXML
    private TableColumn<Empleado, String> colCorreoE;

    @FXML
    private TableColumn<Empleado, String> colContraseniaE;

    @FXML
    private TableColumn<Empleado, Persona> colEstatusE;

    //---------------PROVEEDOR---------------
    @FXML
    private TableView<Proveedor> idTableP;

    @FXML
    private TableColumn<Proveedor, Integer> colIdPersonaP;

    @FXML
    private TableColumn<Proveedor, Persona> colIdProveedorP;

    @FXML
    private TableColumn<Proveedor, Persona> colNombreP;

    @FXML
    private TableColumn<Proveedor, Persona> colApaternoP;

    @FXML
    private TableColumn<Proveedor, Persona> colAmaternoP;

    @FXML
    private TableColumn<Proveedor, Persona> colFechaNacP;

    @FXML
    private TableColumn<Proveedor, Persona> colCalleP;

    @FXML
    private TableColumn<Proveedor, Persona> colNumeroP;

    @FXML
    private TableColumn<Proveedor, Persona> colColoniaP;

    @FXML
    private TableColumn<Proveedor, Persona> colCiudadP;

    @FXML
    private TableColumn<Proveedor, Persona> colEstadoP;

    @FXML
    private TableColumn<Proveedor, Persona> colCpP;

    @FXML
    private TableColumn<Proveedor, String> colRFCP;

    @FXML
    private TableColumn<Proveedor, Persona> colTel1P;

    @FXML
    private TableColumn<Proveedor, Persona> colTel2P;

    @FXML
    private TableColumn<Proveedor, String> colRazonSocialP;

    @FXML
    private TableColumn<Proveedor, Persona> colEstatusP;

    @FXML
    private TextField txtidPersonaP;

    @FXML
    private TextField txtNombreP;

    @FXML
    private TextField txtApellidoPaternoP;

    @FXML
    private TextField txtApellidoMaternoP;

    @FXML
    private TextField txtCalleP;

    @FXML
    private TextField txtColoniaP;

    @FXML
    private TextField txtCiudadP;

    @FXML
    private TextField txtTel1P;

    @FXML
    private TextField txtTel2P;

    @FXML
    private TextField txtIdProveedorP;

    @FXML
    private TextField txtFechaNacimientoP;

    @FXML
    private TextField txtNumeroP;

    @FXML
    private TextField txtEstadoP;

    @FXML
    private TextField txtCpP;

    @FXML
    private TextField txtRazonSocialP;

    @FXML
    private TextField txtRFCP;

    @FXML
    private CheckBox cbxEstatusP;
    
    //----------------------------------ANIMAL---------------------------------
    @FXML
    private TextField txtIDProductoMascota;

    @FXML
    private TextField txtNombreMascota;

    @FXML
    private TextField txtPCompraMascota;

    @FXML
    private TextField txtExistenciasMascota;

    @FXML
    private TextField txtPVentaMascota;

    @FXML
    private TextField txtIDMascota;

    @FXML
    private TextField txtRaza;

    @FXML
    private TextField txtEspecie;

    @FXML
    private TextField txtFechaNacimiento;

    @FXML
    private TextField txtFechaLlegada;

    @FXML
    private CheckBox chbActivo;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnGuardarMascota;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<Mascota> tblMascota;

    @FXML
    private TableColumn<Mascota, Producto> colIDProductoMascota;

    @FXML
    private TableColumn<Mascota, Producto> colNombreMascotas;

    @FXML
    private TableColumn<Mascota, Producto> colPCompraMascotas;

    @FXML
    private TableColumn<Mascota, Producto> colPVentaMascotas;

    @FXML
    private TableColumn<Mascota, Producto> colExistenciasMascotas;

    @FXML
    private TableColumn<Mascota, Producto> colEstatusMascotas;

    @FXML
    private TableColumn<Mascota, Integer> colIDMascota;

    @FXML
    private TableColumn<Mascota, String> colRaza;

    @FXML
    private TableColumn<Mascota, String> colEspecie;

    @FXML
    private TableColumn<Mascota, String> colFNacimiento;

    @FXML
    private TableColumn<Mascota, String> colFLlegada;

    private ObservableList<Mascota> mascotas;
    private ObservableList<Mercancia> mercancias;
    private ObservableList<Empleado> empleados;
    private ObservableList<Proveedor> proveedores;
    Client client = ClientBuilder.newClient();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //------------------------------MERCANCIA------------------------------
        mercancias = FXCollections.observableArrayList();

        colIdMercanciaM.setCellValueFactory(new PropertyValueFactory("id"));
        colIdProductoM.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getId()));
        colNombreM.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getNombre()));
        colExistenciasM.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getExistencias()));
        colPrecioCompraM.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getPrecioCompra()));
        colCodigoBarrasM.setCellValueFactory(new PropertyValueFactory("codigoBarras"));
        colDescripcionM.setCellValueFactory(new PropertyValueFactory("descripcion"));
        colModeloM.setCellValueFactory(new PropertyValueFactory("modelo"));
        colMarcaM.setCellValueFactory(new PropertyValueFactory("marca"));
        colPrecioVentaM.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getPrecioVenta()));
        colEstatusM.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getStatus()));
        cargarMercancia();
        final ObservableList<Mercancia> tablaMercanciaSel = idTableM.getSelectionModel().getSelectedItems();
        tablaMercanciaSel.addListener(selectorTablaMercancia);

        //------------------------------EMPLEADO------------------------------
        empleados = FXCollections.observableArrayList();

        colIdPersonaE.setCellValueFactory(new PropertyValueFactory("id"));
        colIdEmpleadoE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getId()));
        colNombreE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getNombre()));
        colApaternoE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getApellidoPaterno()));
        colAmaternoE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getApellidoMaterno()));
        colFechaNacE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getFechaNacimiento()));
        colTel1E.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getTel1()));
        colTel2E.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getTel2()));
        colCalleE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getCalle()));
        colNoE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getNumero()));
        colColoniaE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getColonia()));
        colCPE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getCp()));
        colCiudadE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getCiudad()));
        colEstadoE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getEstado()));
        colCorreoE.setCellValueFactory(new PropertyValueFactory("correo"));
        colContraseniaE.setCellValueFactory(new PropertyValueFactory("contrasenia"));
        colEstatusE.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getEmpleado().getStatus()));
        cargarEmpleado();
        final ObservableList<Empleado> tablaEmpleadoSel = idTableE.getSelectionModel().getSelectedItems();
        tablaEmpleadoSel.addListener(selectorTablaEmpleados);

        //------------------------------PROVEEDOR------------------------------
        proveedores = FXCollections.observableArrayList();
        colIdPersonaP.setCellValueFactory(new PropertyValueFactory("id"));
        colIdProveedorP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getId()));
        colNombreP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getNombre()));
        colApaternoP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getApellidoPaterno()));
        colAmaternoP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getApellidoMaterno()));
        colFechaNacP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getFechaNacimiento()));
        colTel1P.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getTel1()));
        colTel2P.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getTel2()));
        colCalleP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getCalle()));
        colNumeroP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getNumero()));
        colColoniaP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getColonia()));
        colCpP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getCp()));
        colCiudadP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getCiudad()));
        colEstadoP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getEstado()));
        colRFCP.setCellValueFactory(new PropertyValueFactory("rfc"));
        colRazonSocialP.setCellValueFactory(new PropertyValueFactory("razonSocial"));
        colEstatusP.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProveedor().getStatus()));
        cargarProveedor();
        final ObservableList<Proveedor> tablaProveedorSel = idTableP.getSelectionModel().getSelectedItems();
        tablaProveedorSel.addListener(selectorTablaProveedor);

        //-----------------------------MASCOTAS---------------------------------
        mascotas = FXCollections.observableArrayList();

        colIDProductoMascota.setCellValueFactory(new PropertyValueFactory("id"));
        colIDMascota.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getId()));
        colNombreMascotas.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getNombre()));
        colPCompraMascotas.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getPrecioCompra()));
        colPVentaMascotas.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getPrecioVenta()));
        colExistenciasMascotas.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getExistencias()));
        colEstatusMascotas.setCellValueFactory(param -> new SimpleObjectProperty(param.getValue().getProducto().getStatus()));
        colRaza.setCellValueFactory(new PropertyValueFactory("raza"));
        colEspecie.setCellValueFactory(new PropertyValueFactory("especie"));
        colFNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colFLlegada.setCellValueFactory(new PropertyValueFactory("fechaLlegada"));
        cargarMascota();
        final ObservableList<Mascota> tablaMascotaSel = tblMascota.getSelectionModel().getSelectedItems();
        tablaMascotaSel.addListener(selectorTablaMascota);
    }

    //-----------------------------MERCANCIA------------------------------------
    public void guardarMercancia() {
        if (txtNombreM.getText().equals("") || txtExistenciasM.getText().equals("")
                || txtDescripcionM.getText().equals("") || txtMarcaM.getText().equals("")
                || txtModeloM.getText().equals("") || txtPrecioCompraM.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Informacion Acerca del error");
            alert.setTitle("Error por falta de información ");
            alert.setContentText("Faltan datos escenciales");
            alert.showAndWait();
        } else {
            try {
                Mercancia mercancia = new Mercancia();
                MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
                Response response = client.target("http://localhost:8084/mypetpro/rest/mercancia/save")
                        .queryParam("idMercancia", txtIdMercanciaM.getText())
                        .queryParam("idProducto", txtIdProductoM.getText())
                        .queryParam("nombre", txtNombreM.getText())
                        .queryParam("existencias", txtExistenciasM.getText())
                        .queryParam("precioCompra", txtPrecioCompraM.getText())
                        .queryParam("status", "1")
                        .queryParam("codigoBarras", txtCodigoBarrasM.getText())
                        .queryParam("descripcion", txtDescripcionM.getText())
                        .queryParam("modelo", txtModeloM.getText())
                        .queryParam("marca", txtMarcaM.getText())
                        .queryParam("foto", "")
                        .request().post(Entity.form(map));
                System.out.println("Response:" + response);
                cargarMercancia();
                limpiarMercancia();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error!");
                alert.setTitle("ERROR");
                alert.setContentText("No se pudo registrar la mercancía");
                alert.showAndWait();
            }
        }
    }

    public void limpiarMercancia() {
        txtIdProductoM.setText("");
        txtIdMercanciaM.setText("");
        txtCodigoBarrasM.setText("");
        txtNombreM.setText("");
        txtMarcaM.setText("");
        txtModeloM.setText("");
        txtExistenciasM.setText("");
        txtDescripcionM.setText("");
        txtPrecioCompraM.setText("");
        txtPrecioVentaM.setText("");
        cbxEstatusM.setSelected(false);
    }

    //metodo de cargar mercancia
    public void cargarMercancia() {
        try {
            String response = client.target("http://localhost:8084/mypetpro/rest/mercancia/getAll")
                    .request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            System.out.println("Response: " + response);

            Gson gson = new Gson();
            ArrayList<Mercancia> listMercancia = gson.
                    fromJson(response, new TypeToken<List<Mercancia>>() {
                    }.getType());
            mercancias = FXCollections.observableArrayList(listMercancia);
            idTableM.setItems(mercancias);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //Listener de la tabla mercancia
    private final ListChangeListener<Mercancia> selectorTablaMercancia
            = new ListChangeListener<Mercancia>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Mercancia> c) {
            ponerMercanciaSeleccionada();
        }
    };

    //PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaMercancia"
    public Mercancia getTablaMercanciaSeleccionada() {
        if (idTableM != null) {
            List<Mercancia> tabla = idTableM.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Mercancia competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    // Método para poner en los textFields la tupla que selccionemos
    private void ponerMercanciaSeleccionada() {
        final Mercancia m = getTablaMercanciaSeleccionada();
        int posicionMercanciaEnTabla = mercancias.indexOf(mercancias);

        if (m != null) {
            //txtIdProductoM.setText(String.valueOf(m.getIdProducto();
            txtIdProductoM.setText(String.valueOf(m.getProducto().getId()));
            txtIdMercanciaM.setText(String.valueOf(m.getId()));
            txtCodigoBarrasM.setText(m.getCodigoBarras());
            txtNombreM.setText(m.getProducto().getNombre());
            txtMarcaM.setText(m.getMarca());
            txtModeloM.setText(m.getModelo());
            txtExistenciasM.setText(m.getProducto().getExistencias() + "");
            txtDescripcionM.setText(m.getDescripcion());
            txtPrecioCompraM.setText(m.getProducto().getPrecioCompra() + "");
            txtPrecioVentaM.setText(m.getProducto().getPrecioVenta() + "");
            if (m.getProducto().getStatus() == 1) {
                cbxEstatusM.setSelected(true);
            } else {
                cbxEstatusM.setSelected(false);
            }
        }
    }

    public void eliminarMercancia() {
        try {
            MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
            Response response = client.target("http://localhost:8084/mypetpro/rest/mercancia/delete")
                    .queryParam("idProducto", txtIdProductoM.getText())
                    .request().post(Entity.form(map));
            System.out.println("Response:" + response);
            cargarMercancia();
            cbxEstatusM.setSelected(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarSesion(ActionEvent event) throws IOException {
        Stage stages = (Stage) idMenuBar.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("/org/lila_systems/mypet/gui/fxml/Login.fxml"));
        Scene scene3 = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene3);
        stage.setTitle("Sistema MyPet");
        stage.setResizable(false);
        stage.show();
    }

    //------------------------------EMPLEADO------------------------------------
    @FXML
    public void guardarEmpleado() {
        if (txtNombreE.getText().equals("") || txtApellidoPaternoE.getText().equals("")
                || txtTel1E.getText().equals("") || txtColoniaE.getText().equals("")
                || txtCiudadE.getText().equals("") || txtCorreoE.getText().equals("")
                || txtContraseniaE.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Informacion Acerca del error");
            alert.setTitle("Error por falta de información ");
            alert.setContentText("Faltan datos escenciales");
            alert.showAndWait();
        } else {
            try {
                Proveedor proveedor = new Proveedor();
                MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
                Response response = client.target("http://localhost:8084/mypetpro/rest/empleado/save")
                        .queryParam("idEmpleado", txtIdPersonaE.getText())
                        .queryParam("idPersona", txtIdEmpleadoE.getText())
                        .queryParam("nombre", txtNombreE.getText())
                        .queryParam("apellidoPaterno", txtApellidoPaternoE.getText())
                        .queryParam("apellidoMaterno", txtApellidoMaternoE.getText())
                        .queryParam("fechaNacimiento", txtFechaNacimientoE.getText())
                        .queryParam("calle", txtCalleE.getText())
                        .queryParam("numero", txtNoE.getText())
                        .queryParam("colonia", txtColoniaE.getText())
                        .queryParam("cp", txtCPE.getText())
                        .queryParam("ciudad", txtCiudadE.getText())
                        .queryParam("estado", txtEstadoE.getText())
                        .queryParam("tel1", txtTel1E.getText())
                        .queryParam("tel2", txtTel2E.getText())
                        .queryParam("correo", txtCorreoE.getText())
                        .queryParam("contrasenia", txtContraseniaE.getText())
                        .queryParam("status", "1")
                        .request().post(Entity.form(map));
                System.out.println("Response:" + response);
                cargarEmpleado();
                limpiarEmpleado();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error!");
                alert.setTitle("ERROR");
                alert.setContentText("No se pudo registrar el empleado");
                alert.showAndWait();
            }
        }
    }

    public void cargarEmpleado() {
        try {
            String response = client.target("http://localhost:8084/mypetpro/rest/empleado/getAll")
                    .request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            System.out.println("Response: " + response);

            Gson gson = new Gson();
            ArrayList<Empleado> listEmpleado = gson.
                    fromJson(response, new TypeToken<List<Empleado>>() {
                    }.getType());
            empleados = FXCollections.observableArrayList(listEmpleado);
            idTableE.setItems(empleados);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado() {
        try {
            MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
            Response response = client.target("http://localhost:8084/mypetpro/rest/empleado/delete")
                    .queryParam("idPersona", txtIdPersonaE.getText())
                    .request().post(Entity.form(map));
            System.out.println("Response:" + response);
            cargarMercancia();
            cbxEstatusM.setSelected(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limpiarEmpleado() {
        txtIdPersonaE.setText("");
        txtIdEmpleadoE.setText("");
        txtNombreE.setText("");
        txtApellidoPaternoE.setText("");
        txtApellidoMaternoE.setText("");
        txtFechaNacimientoE.setText("");
        txtTel1E.setText("");
        txtTel2E.setText("");
        txtCalleE.setText("");
        txtNoE.setText("");
        txtColoniaE.setText("");
        txtCPE.setText("");
        txtCiudadE.setText("");
        txtEstadoE.setText("");
        txtCorreoE.setText("");
        txtContraseniaE.setText("");
        cbxEstatusE.setSelected(false);
    }

    @FXML
    private void eventInt(KeyEvent event) {
        Object evt = event.getSource();

        if (evt.equals(txtExistenciasM)) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                event.consume();
            }
        }
    }

    @FXML
    private void eventKey(KeyEvent event) {
        Object evt = event.getSource();

        if (evt.equals(txtPrecioCompraM)) {
            if (!Character.isDigit(event.getCharacter().charAt(0)) && !event.getCharacter().equals(".")) {
                event.consume();
            }
        }

    }

    @FXML
    private void eventKey1(KeyEvent event) {
        Object evt = event.getSource();

        if (evt.equals(txtCPE)) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                event.consume();
            }
        }

    }
    //Listener de la tabla personas
    private final ListChangeListener<Empleado> selectorTablaEmpleados
            = new ListChangeListener<Empleado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Empleado> e) {
            ponerEmpleadoSeleccionado();
        }
    };

    //PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
    public Empleado getTablaEmpleadoSeleccionado() {
        if (idTableE != null) {
            List<Empleado> tabla = idTableE.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Empleado competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    //Método para poner en los textFields la tupla que selccionemos
    private void ponerEmpleadoSeleccionado() {
        final Empleado e = getTablaEmpleadoSeleccionado();
        int posicionPersonaEnTabla = empleados.indexOf(empleados);

        if (e != null) {
            txtIdPersonaE.setText(String.valueOf(e.getEmpleado().getId()));
            txtIdEmpleadoE.setText(String.valueOf(e.getId()));
            txtNombreE.setText(e.getEmpleado().getNombre());
            txtApellidoPaternoE.setText(e.getEmpleado().getApellidoPaterno());
            txtApellidoMaternoE.setText(e.getEmpleado().getApellidoMaterno());
            txtFechaNacimientoE.setText(e.getEmpleado().getFechaNacimiento());
            txtTel1E.setText(e.getEmpleado().getTel1());
            txtTel2E.setText(e.getEmpleado().getTel2());
            txtCalleE.setText(e.getEmpleado().getCalle());
            txtNoE.setText(e.getEmpleado().getNumero());
            txtColoniaE.setText(e.getEmpleado().getColonia());
            txtCPE.setText(e.getEmpleado().getCp() + "");
            txtCiudadE.setText(e.getEmpleado().getCiudad());
            txtEstadoE.setText(e.getEmpleado().getEstado());
            txtCorreoE.setText(e.getCorreo());
            txtContraseniaE.setText(e.getContrasenia());
            if (e.getEmpleado().getStatus() == 1) {
                cbxEstatusE.setSelected(true);
            } else {
                cbxEstatusE.setSelected(false);
            }
        }
    }

    public void modificarEmpleado() {
    }

    //-----------------------------PROVEEDOR------------------------------------
    public void guardarProveedor() {
        if (txtNombreP.getText().equals("") || txtApellidoPaternoP.getText().equals("") || txtTel1P.getText().equals("")
                || txtColoniaP.getText().equals("") || txtCiudadP.getText().equals("") || txtEstadoP.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Informacion Acerca del error");
            alert.setTitle("Error por falta de información ");
            alert.setContentText("Faltan datos escenciales");
            alert.showAndWait();
        } else {
            try {
                MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
                Response response = client.target("http://localhost:8084/mypetpro/rest/proveedor/save")
                        .queryParam("idProveedor", txtidPersonaP.getText())
                        .queryParam("idRepresentante", txtIdProveedorP.getText())
                        .queryParam("nombre", txtNombreP.getText())
                        .queryParam("apellidoPaterno", txtApellidoPaternoP.getText())
                        .queryParam("apellidoMaterno", txtApellidoMaternoP.getText())
                        .queryParam("fechaNacimiento", txtFechaNacimientoP.getText())
                        .queryParam("calle", txtCalleP.getText())
                        .queryParam("numero", txtNumeroP.getText())
                        .queryParam("colonia", txtColoniaP.getText())
                        .queryParam("cp", txtCpP.getText())
                        .queryParam("ciudad", txtCiudadP.getText())
                        .queryParam("estado", txtEstadoP.getText())
                        .queryParam("tel1", txtTel1P.getText())
                        .queryParam("tel2", txtTel2P.getText())
                        .queryParam("rfc", txtRFCP.getText())
                        .queryParam("razonSocial", txtRazonSocialP.getText())
                        .queryParam("status", "1")
                        .request().post(Entity.form(map));
                System.out.println("Response:" + response);
                cargarProveedor();
                limpiarProveedor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarProveedor() {
        try {
            MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
            Response response = client.target("http://localhost:8084/mypetpro/rest/proveedor/delete")
                    .queryParam("idPersona", txtidPersonaP.getText())
                    .request().post(Entity.form(map));
            System.out.println("Response:" + response);
            cargarProveedor();
            cbxEstatusP.setSelected(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarProveedor() {
        try {
            String response = client.target("http://localhost:8084/mypetpro/rest/proveedor/getAll")
                    .request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            System.out.println("Response: " + response);

            Gson gson = new Gson();
            ArrayList<Proveedor> listProveedor = gson.
                    fromJson(response, new TypeToken<List<Proveedor>>() {
                    }.getType());
            proveedores = FXCollections.observableArrayList(listProveedor);
            idTableP.setItems(proveedores);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final ListChangeListener<Proveedor> selectorTablaProveedor
            = new ListChangeListener<Proveedor>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Proveedor> p) {
            ponerProveedorSeleccionado();
        }
    };

    public Proveedor getTablaProveedorSeleccionado() {
        if (idTableP != null) {
            List<Proveedor> tabla = idTableP.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Proveedor competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    //Método para poner en los textFields la tupla que selccionemos
    private void ponerProveedorSeleccionado() {
        final Proveedor p = getTablaProveedorSeleccionado();
        int posicionPersonaEnTabla = proveedores.indexOf(proveedores);

        if (p != null) {
            txtidPersonaP.setText(String.valueOf(p.getProveedor().getId()));
            txtIdProveedorP.setText(String.valueOf(p.getId()));

            txtNombreP.setText(p.getProveedor().getNombre());
            txtApellidoPaternoP.setText(p.getProveedor().getApellidoPaterno());
            txtApellidoMaternoP.setText(p.getProveedor().getApellidoMaterno());
            txtFechaNacimientoP.setText(p.getProveedor().getFechaNacimiento());
            txtTel1P.setText(p.getProveedor().getTel1());
            txtTel2P.setText(p.getProveedor().getTel2());
            txtCalleP.setText(p.getProveedor().getCalle());
            txtNumeroP.setText(p.getProveedor().getNumero());
            txtColoniaP.setText(p.getProveedor().getColonia());
            txtCpP.setText(p.getProveedor().getCp() + "");
            txtCiudadP.setText(p.getProveedor().getCiudad());
            txtEstadoP.setText(p.getProveedor().getEstado());
            txtRFCP.setText(p.getRfc());
            txtRazonSocialP.setText(p.getRazonSocial());
            if (p.getProveedor().getStatus() == 1) {
                cbxEstatusP.setSelected(true);
            } else {
                cbxEstatusP.setSelected(false);
            }
        }
    }

    public void limpiarProveedor() {
        txtidPersonaP.setText("");
        txtIdProveedorP.setText("");
        txtNombreP.setText("");
        txtApellidoPaternoP.setText("");
        txtApellidoMaternoP.setText("");
        txtFechaNacimientoP.setText("");
        txtTel1P.setText("");
        txtTel2P.setText("");
        txtCalleP.setText("");
        txtNumeroP.setText("");
        txtColoniaP.setText("");
        txtCpP.setText("");
        txtCiudadP.setText("");
        txtEstadoP.setText("");
        txtRFCP.setText("");
        txtRazonSocialP.setText("");
        cbxEstatusP.setSelected(false);
    }

   //--------------MASCOTAS----------------------
    public void guardarMascota() {
        if (txtNombreMascota.getText().equals("") || txtExistenciasMascota.getText().equals("")
                || txtPCompraMascota.getText().equals("") || txtFechaNacimiento.getText().equals("")
                || txtFechaLlegada.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Información acerca del error");
            alert.setTitle("Error por falta de información");
            alert.setContentText("Faltan datos escencales");
            alert.showAndWait();
        } else {
            try {
                Mascota mascota = new Mascota();
                MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
                Response response = client.target("http://localhost:8084/mypetpro/rest/mascota/save")
                        .queryParam("idMascota", txtIDMascota.getText())
                        .queryParam("idProducto", txtIDProductoMascota.getText())
                        .queryParam("nombre", txtNombreMascota.getText())
                        .queryParam("precioCompra", txtPCompraMascota.getText())
                        .queryParam("existencias", txtExistenciasMascota.getText())
                        .queryParam("status", "1")
                        .queryParam("raza", txtRaza.getText())
                        .queryParam("especie", txtEspecie.getText())
                        .queryParam("especie", txtEspecie.getText())
                        .queryParam("fechaNacimiento", txtFechaNacimiento.getText())
                        .queryParam("fechaLlegada", txtFechaLlegada.getText())
                        .request().post(Entity.form(map));
                System.out.println("Response: " + response);
                cargarMascota();
                limpiarMascota();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("!ERROR!");
                alert.setTitle("ERROR");
                alert.setContentText("No se pudo registrar la mercancía");
                alert.showAndWait();

            }
        }
    }

    public void cargarMascota() {
        try {
            String response = client.target("http://localhost:8084/mypetpro/rest/mascota/getAll")
                    .request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            System.out.println("Response: " + response);

            Gson gson = new Gson();
            ArrayList<Mascota> listMascota = gson.
                    fromJson(response, new TypeToken<List<Mascota>>() {
                    }.getType());
            mascotas = FXCollections.observableArrayList(listMascota);
            tblMascota.setItems(mascotas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final ListChangeListener<Mascota> selectorTablaMascota
            = new ListChangeListener<Mascota>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Mascota> c) {
            ponerMascotasSeleccionado();
        }

    };

    private void ponerMascotasSeleccionado() {
        final Mascota m = getTablaMascotaSeleccionado();
        int posicionProductoEnTabla = mascotas.indexOf(mascotas);

        if (m != null) {
            txtIDProductoMascota.setText(String.valueOf(m.getProducto().getId()));
            txtIDMascota.setText(String.valueOf(m.getId()));

            txtNombreMascota.setText(m.getProducto().getNombre());
            txtPCompraMascota.setText(m.getProducto().getPrecioCompra() + "");
            txtPVentaMascota.setText(m.getProducto().getPrecioVenta() + "");
            txtExistenciasMascota.setText(m.getProducto().getExistencias() + "");
            txtRaza.setText(String.valueOf(m.getRaza()));
            txtEspecie.setText(String.valueOf(m.getEspecie()));
            txtFechaNacimiento.setText(String.valueOf(m.getFechaNacimiento()));
            txtFechaLlegada.setText(String.valueOf(m.getFechaLlegada()));
            if (m.getProducto().getStatus() == 1) {
                chbActivo.setSelected(true);
            } else {
                chbActivo.setSelected(false);
            }

        }
    }

    private Mascota getTablaMascotaSeleccionado() {
        if (tblMascota != null) {
            List<Mascota> tabla = tblMascota.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Mascota competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    public void limpiarMascota() {
        txtIDProductoMascota.setText("");
        txtIDMascota.setText("");
        txtNombreMascota.setText("");
        txtExistenciasMascota.setText("");
        txtPCompraMascota.setText("");
        txtPVentaMascota.setText("");
        txtEspecie.setText("");
        txtRaza.setText("");
        txtFechaNacimiento.setText("");
        txtFechaLlegada.setText("");
        chbActivo.setSelected(false);
    }

    public void eliminarMascota() {
        try {
            MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
            Response response = client.target("http://localhost:8084/mypetpro/rest/mascota/delete")
                    .queryParam("idProducto", txtIDProductoMascota.getText())
                    .request().post(Entity.form(map));
            System.out.println("Response:" + response);
            cargarMascota();
            chbActivo.setSelected(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
