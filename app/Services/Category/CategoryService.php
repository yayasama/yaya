<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 8/12/2016
 * Time: 3:48 PM
 */

namespace App\Services\Category;


use App\Model\Category;
use App\Services\Service;

class CategoryService extends Service
{

    protected $category;

    /**
     * CategoryService constructor.
     * @param $category
     */
    public function __construct(Category $category)
    {
        $this->category = $category;
    }


    /**
     * 获取所有分类
     *
     * @return array
     */
    public function getAll()
    {
        return Category::all() ?: [];
    }


    /**
     * 新增一个分类
     *
     * @param Category $categoryInfo
     * @return bool
     */
    public function save(Category $categoryInfo)
    {
        return $categoryInfo->save();
    }


    /**
     * 根据分类名查找对象
     *
     * @param string $name
     * @return array
     */
    public function getByName($name = '')
    {
        return $this->category->getByName($name);
    }


    public function drop($id = 0)
    {
        Category::destroy($id);
    }


    public function get($id = 0)
    {
        return Category::find($id);
    }


}