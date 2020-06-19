package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main extends Application {

    private final TableView tableView=new TableView();
    private final int screenWidth=800;
    private final int screenHeight=800;
    Connect connect=new Connect();
    List<HashMap<String, String>> list_all=new ArrayList<HashMap<String,String>>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene=new Scene(new Group());
        primaryStage.setTitle("表格连接数据库实例");
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHeight);
        tableView.setPrefSize(screenWidth,screenHeight);

        int colWidth=screenWidth/6;
        TableColumn idCol=new TableColumn("事件序号");
        idCol.setPrefWidth(colWidth);
        TableColumn timeCol=new TableColumn("触发时间");
        timeCol.setPrefWidth(colWidth);
        TableColumn stageCol=new TableColumn("触发台站");
        stageCol.setPrefWidth(colWidth);
        TableColumn zuobiaoCol=new TableColumn("定位坐标");
        zuobiaoCol.setPrefWidth(colWidth);
        TableColumn energyCol=new TableColumn("能量/J");
        energyCol.setPrefWidth(colWidth);
        TableColumn jibieCol=new TableColumn("震级");
        jibieCol.setPrefWidth(colWidth);

        tableView.getColumns().addAll(idCol,timeCol,stageCol,zuobiaoCol,energyCol,jibieCol);
        ((Group) scene.getRoot()).getChildren().addAll(tableView);

        //进行数据绑定
        connect.initDB();
        connect.selectAll();
        //将数据库中查询出来的list赋值给list_all
        list_all=connect.list;
//        System.out.printf(list_all.get(0).get("id"));
       ObservableList dataList = FXCollections.observableArrayList();
        for (int i=0;i<list_all.size();i++){
            dataList.add(new SelectData(list_all.get(i).get("id"),list_all.get(i).get("time"),list_all.get(i).get("station"),
                       list_all.get(i).get("zuobiao"),list_all.get(i).get("energy"),list_all.get(i).get("jibie")));
        }
        //与组件进行绑定
        idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("Time"));
        stageCol.setCellValueFactory(new PropertyValueFactory<>("Station"));
        zuobiaoCol.setCellValueFactory(new PropertyValueFactory<>("Zuobiao"));
        energyCol.setCellValueFactory(new PropertyValueFactory<>("Energy"));
        jibieCol.setCellValueFactory(new PropertyValueFactory<>("Jibie"));
        tableView.setItems(dataList);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
