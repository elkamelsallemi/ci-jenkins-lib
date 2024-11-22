package org.demoJenkins.dto

class InputDTO implements Serializable{
    String name
    String gitUrl
    String extraParam

    InputDTO(Map setInputValuesDTO){
        setInputDTO(setInputValuesDTO)
    }

    def setInputDTO(Map setInputValuesDTO) {
        this.name = setInputValuesDTO.name ?: 'defaultName'
        this.gitUrl = setInputValuesDTO.gitUrl ?: 'defaultUrl'
        this.extraParam = setInputValuesDTO.extraParam ?: 'defaultExtraParam'
    }
}
