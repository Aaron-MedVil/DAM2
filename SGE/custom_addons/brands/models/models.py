# -*- coding: utf-8 -*-

from odoo import models, fields, api, exceptions

## Modelo del formulario para crear un registro many2one
class Brand(models.Model):
    _name = 'brand.template'
    _description = 'Brands'

    # Campos que se mostraran en la interfaz
    name = fields.Char(string="Name")
    logo = fields.Image(string="Logo", max_width=10, max_height=10)
    subBrand = fields.Many2one("brand.template", string="Sub Brand Of")
    company = fields.Many2one("res.partner", string="Company")
    contact = fields.Many2one("res.partner", string="Contact")

    # Metodo para comprobar que no hay recursividad en la relacion
    @api.constrains('subBrand')
    def _check_subrand_recursion(self):
        if not self._check_recursion(parent='subBrand'):
            raise exceptions.ValidationError(('You cannot create recursive relationships.'))



## Modelo para la vista de producto
class CustomBrand(models.Model):
    _inherit = 'product.template'
    brand = fields.Many2one("brand.template", string="Brand")