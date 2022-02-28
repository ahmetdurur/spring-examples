package com.haydikodlayalim;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet nesnesi" , description = "Pet aciklama")
public class Pet {

    @ApiModelProperty(value = "pet nesnesinin id alani")
    private int id;
    @ApiModelProperty(value = "pet nesnesinin adi alani")
    private  String name;
    @ApiModelProperty(value = "pet nesnesinin tarih alani")
    private Date date;
}
