package org.utl.dsm.MongoBlog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "image_source")
public class ImageSource {
    @Id
    private Long idImage;
    private String fechaSubida;
    @NonNull
    private String formato;
    @NonNull
    private String nombreArchivo;
    @Indexed
    private String usuario;
}