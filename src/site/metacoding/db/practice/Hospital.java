package site.metacoding.db.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Hospital {

	private String addr;

	private Integer mgtStaDd;

	private String pcrPsblYn;

	private String ratPsblYn;

	private Integer recuClCd;

	private String sgguCdNm;

	private String sidoCdNm;

	private String XPosWgs84;

	private String YPosWgs84;

	private String yadmNm;

	private String ykihoEnc;
}
