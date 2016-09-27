<?php

namespace App\Util;

use Config;

class JsonUtil
{

    public static function toJson($code = 0, $data = [])
    {

        $msgMap = Config::get('member.statusMap.status');

        $output = [
            'code' => $code,
            'msg' => $msgMap[$code] ?: 'unknown code',
            'data' => $data
        ];

        return json_encode($output);
    }


}