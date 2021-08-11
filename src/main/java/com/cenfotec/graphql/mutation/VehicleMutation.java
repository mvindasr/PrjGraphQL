package com.cenfotec.graphql.mutation;

import com.cenfotec.graphql.entities.Vehicle;
import com.cenfotec.graphql.services.VehicleService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class VehicleMutation implements GraphQLMutationResolver {
    @Autowired
    private VehicleService vehicleService;
    public Vehicle createVehicle(String type, String modelCode, String brandName, String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }

    public Vehicle updateVehicle(int id, String type, String modelCode,
                                 String brandName,
                                 String launchDate) {
        Optional<Vehicle> vehicle = this.vehicleService.getVehicle(id);
        if (vehicle.isPresent()) {
            Vehicle vehicleEntity = vehicle.get();
            if (type!=null) {
                vehicleEntity.setType(type);
            }
            if (modelCode!=null) {
                vehicleEntity.setModelCode(modelCode);
            }
            if (brandName!=null) {
                vehicleEntity.setBrandName(brandName);
            }
            if (launchDate!=null) {
                vehicleEntity.setLaunchDate(LocalDate.parse(launchDate));
            }
            vehicleService.save(vehicleEntity);
            return vehicleEntity;
        }
        return null;
    }
}
