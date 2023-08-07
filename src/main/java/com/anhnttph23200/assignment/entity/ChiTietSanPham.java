package com.anhnttph23200.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "ChiTietSP")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSanPham dongSanPham;

    @NotNull(message = "Không bỏ trống")
    @Min(value = 2023, message = "Không được trước năm 2023")
    @Column(name = "NamBH")
    private String namBH;

    @NotBlank(message = "Không bỏ trống")
    @Column(name = "MoTa")
    private String mota;

    @NotNull(message = "Không bỏ trống")
    @Min(value = 0, message = "Không được <0")
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @NotNull(message = "Không bỏ trống")
    @Min(value = 1000, message = "Không được < 1000")
    @Column(name = "GiaNhap")
    private Integer giaNhap;

    @NotNull(message = "Không bỏ trống")
    @Min(value = 1000, message = "Không được < 1000")
    @Column(name = "GiaBan")
    private Integer giaBan;
}
