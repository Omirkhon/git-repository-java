package HierarchyCars;

public class BusType extends VehicleTypeByBodyTypes {

    @Override
    public String getTypeName() {
        return VehicleTypeEnum.BUS.name();
    }
}
