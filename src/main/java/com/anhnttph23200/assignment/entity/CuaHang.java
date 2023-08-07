package com.anhnttph23200.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "CuaHang")
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "Ten")
    private String ten;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "ThanhPho")
    private String thanhPho;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "QuocGia")
    private String quocGia;
}
