package cs.sicnu.fiveg.mapper;

import cs.sicnu.fiveg.pojo.FileDownload;
import java.util.List;

public interface FileDownloadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_download
     *
     * @mbg.generated
     */
    int insert(FileDownload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_download
     *
     * @mbg.generated
     */
    List<FileDownload> selectAll();
}