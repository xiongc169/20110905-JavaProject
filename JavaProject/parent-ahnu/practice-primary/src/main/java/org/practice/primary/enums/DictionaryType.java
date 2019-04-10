package org.practice.primary.enums;

/**
 * 字典类型
 *
 * @author
 */
public enum DictionaryType {
    /**
     * 性别
     */
    Sex("DictionaryType.Sex.text"),
    /**
     * 通话性别
     */
    CallSex("DictionaryType.CallSex.text"),
    /**
     * 通话信道
     */
    CallTrance("DictionaryType.CallTrance.text"),
    /**
     * 通话信道
     */
    CallVlidLen("DictionaryType.CallVlidLen.text"),
    /**
     * 性别
     */
    Gender("DictionaryType.Gender.text"),
    /**
     * 人员状态
     */
    PersonStatus("DictionaryType.PersonStatus.text"),
    /**
     * 业务系统
     */
    BizSystem("DictionaryType.BizSystem.text"),
    /**
     * 识别系统
     */
    RecognizeSys("DictionaryType.RecognizeSys.text"),
    /**
     * 任务类型
     */
    TaskType("DictionaryType.TaskType.text"),
    /**
     * 技术类型
     */
    TechType("DictionaryType.TechType.text"),
    /**
     * 数据源
     */
    DataSource("DictionaryType.DataSource.text"),
    /**
     * 监控状态
     */
    MonitorStatus("DictionaryType.MonitorStatus.text"),
    /**
     * 任务状态
     */
    TaskStatus("DictionaryType.TaskStatus.text"),
    /**
     * RuleType
     */
    RuleType("DictionaryType.RuleType.text"),
    /**
     * 上层业务系统
     */
    TopBizSystem("DictionaryType.TopBizSystem.text"),
    /**
     * 检查任务技术类型
     */
    SearchTaskTechType("DictionaryType.SearchTaskTechType.text"),
    /**
     * 新建关键词页业务系统类型
     */
    KwsBizSystem("DictionaryType.KwsBizSystem.text"),
    /**
     * MethdoType
     */
    MethodType("DictionaryType.MethodType.text");

    /**
     * 文本
     */
    private String text;

    /**
     * 构造函数
     *
     * @param text 文本
     */
    private DictionaryType(String text) {
        this.text = text;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
}
