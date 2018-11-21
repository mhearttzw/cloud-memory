/*
package com.cloud.memory.common.validation;

import com.cloud.memory.common.annotation.CheckBasisAssetParam;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

*/
/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/9/29 17:32
 * @description      基础资产信息关联校验
 *//*

public class CheckBasisAssetValidator implements ConstraintValidator<CheckBasisAssetParam, FundApplySubmitModel> {

    @Override
    public void initialize(CheckBasisAssetParam constraintAnnotation) {

    }

    @Override
    public boolean isValid(FundApplySubmitModel fundApplyInfo, ConstraintValidatorContext context) {
        if (fundApplyInfo.getIsAssetTransfer().equals(YesNoStatus.YES)) {
            // 转让资产类型
            TransferAssetType assetType = fundApplyInfo.getTransferAssetType();
            // 基础合同编号
            String basisContractNum = fundApplyInfo.getBasisContractNumber();
            // 基础合同交易金额
            BigDecimal basisContractTradeAmount = fundApplyInfo.getBasisContractTradeAmount();
            // 基础合同下债务人名称
            String basisContrDebtorName = fundApplyInfo.getBasisContractDebtorName();
            if (assetType == null && basisContractNum == null && basisContractTradeAmount == null && basisContrDebtorName == null) {
                return false;
            }
            return true;
        }
        return true;
    }
}
*/
